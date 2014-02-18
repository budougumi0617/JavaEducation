/**
 * @file
 * @par File Name:
 * CheckNextGaussian.java
 * @author budougumi0617
 * @date Created on 2014/01/06
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author budougumi0617
 *         nextGaussianを検査するプログラムを作成して、
 *         膨大な数の呼び出し結果をグラフ（*文字の棒グラフ）で表示しなさい。
 */
public class CheckNextGaussian {
	private static Random random = new Random();
	List<Integer> countResultList;
	final int trialNum = 10000;

	CheckNextGaussian() {
		countResultList = new ArrayList<Integer>(100);
	}

	String createGraph(int count) {
		String result = "";
		int starNum = count;// / trialNum;
		for (int i = 0; i < starNum; i++) {
			result += "*";
		}
		return result;
	}

	int computeAddNumber(double num) {
		int result = (int) ((num + 2) * 100)/2;
		return result;
	}

	void computeGaussian() {
		double doubleValue;
		int result;
		for (int i = 0; i < 100; i++) {
			countResultList.add(0, 0);
		}
		for (int i = 0; i < trialNum; i++) {
			doubleValue = random.nextGaussian();
			System.out.println(doubleValue);
			result = computeAddNumber(doubleValue);
			if (0 <= result && result < 100) {
				countResultList.set(result, countResultList.get(result) + 1);
			}
		}
	}

	public void printResultValue() {
		System.out.println("正規分布グラフ 試行回数: " + trialNum);
		for (int i = 0; i < countResultList.size(); i++) {
			System.out.println(createGraph(countResultList.get(i)));
		}
	}

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		CheckNextGaussian cng = new CheckNextGaussian();
		cng.computeGaussian();
		cng.printResultValue();
		System.out.println(5&6);
		System.out.println(10&13);
		System.out.println(30|40);
	}

}
