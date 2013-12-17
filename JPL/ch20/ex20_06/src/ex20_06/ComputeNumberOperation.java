/*
 * @file
 * @par File Name:
 * ComputeNumberOperation.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/15
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yoichiro Shimizu name op
 *         value形式の入力を受け取るプログラムを作成しなさい。nameは自分で選んだ3個の単語のひとつで、
 *         opは+、-、=のどれかで、、valueはかずです。名前付値に各演算子を適用しなさい。 入力がなくなったら、３つの値を表示しなさい。
 */
public class ComputeNumberOperation {
	private static Map<String, Integer> list = new HashMap<String, Integer>();

	enum op {
		PLUS {

			@Override
			void changeVaueByOperation(String name, int value) {
				list.put(name, list.remove(name) + value);
			}

		},
		EQUAL {

			@Override
			void changeVaueByOperation(String name, int value) {
				list.remove(name);
				list.put(name, value);
			}

		},
		MINUS {

			@Override
			void changeVaueByOperation(String name, int value) {
				list.put(name, list.remove(name) - value);
			}

		};

		abstract void changeVaueByOperation(String name, int value);
	}

	public ComputeNumberOperation() {
		list.put("one", 0);
		list.put("two", 0);
		list.put("three", 0);
	}

	public void changeValue(String inputString) {
		String[] inputStrings = inputString.split(" ");
		if (inputStrings.length != 4 || list.get(inputStrings[0]) == null) {
			System.out.println("one " + list.get("one"));
			System.out.println("two " + list.get("two"));
			System.out.println("three " + list.get("three"));
			return;
		}
		inputStrings[2] = inputStrings[2].replaceAll("\\r\\n", "");
		inputStrings[2] = inputStrings[2].replaceAll("\\n", "");
		if (inputStrings[1].equals("+")) {
			op.PLUS.changeVaueByOperation(inputStrings[0],
					Integer.valueOf(inputStrings[2]));
		} else if (inputStrings[1].equals("=")) {
			op.EQUAL.changeVaueByOperation(inputStrings[0],
					Integer.valueOf(inputStrings[2]));
		} else if (inputStrings[1].equals("-")) {
			op.MINUS.changeVaueByOperation(inputStrings[0],
					Integer.valueOf(inputStrings[2]));
		} else {

		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		byte buf[] = new byte[128];
		ComputeNumberOperation computeNumberOperation = new ComputeNumberOperation();
		while ((System.in.read(buf)) != -1) {
			String bufString = new String(buf, "utf-8");
			System.out.println("input " + bufString.toString());
			computeNumberOperation.changeValue(bufString.toString());
			System.out.println();
		}

	}

}
