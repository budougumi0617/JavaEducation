/**
 * @file
 * @par File Name:
 * PrintFloatArray.java
 * @author budougumi0617
 * @date Created on 2014/01/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.Formatter;

import javax.print.PrintService;

/**
 * @author budougumi0617
 * 
 *         浮動小数点の配列と、縦の列を何列使用するかを指定する数字を受け取り、
 *         配列の内容を表示するメソッドを書きなさい
 *         。各縦列のエントリーが綺麗に整列することを
 *         保証するようにしなさい。1行は80文字と想定してください。
 */
public class PrintFloatArray{

	Double doubleList[];
	double doubleValue;
	static final int maxCharacterNum = 80;
	int lineCount;

	PrintFloatArray(Double[] input, int lineCount) {
		doubleList = input;
		this.lineCount = lineCount;
	}
	String analysisFormat() throws IOException{
		String result = "";
		if(lineCount > 12){
			System.out.println("Too a lot of input number");
			throw new IOException();
		}
		int charNum = maxCharacterNum / lineCount;
		result = "%" + charNum +".4f";
		return result;
	}
	void printFloatList(){
		System.out.println("lincount = " + lineCount);
		for(int i = 0; i < doubleList.length; i ++){
			if(i != 0 && i % lineCount == 0){
				System.out.println();
			}
			System.out.print(printString(doubleList[i]));
		}
		System.out.println();
	}
	

	/**
	 * @param lineCount セットする lineCount
	 */
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Double> inputList = new ArrayList<Double>();
		for(int i = 0; i < 100; i++){
			inputList.add(Math.random() * i);
		}
		Double input[] = inputList.toArray(new Double[0]);
		PrintFloatArray pfa = new PrintFloatArray(input, 4);
		pfa.printFloatList();
		pfa.setLineCount(9);
		pfa.printFloatList();
		
	}
	String printString(double value){
		String format = null;
		try {
			format = analysisFormat();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String after = String.format(format, value);
		return after;
	}

	

}
