/**
 * @file
 * @par File Name:
 * DataHandler.java
 * @author budougumi0617
 * @date Created on 2014/02/06
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_02;

import java.io.File;
import java.util.WeakHashMap;

/**
 * @author budougumi0617
 * @note P400のDataHandlerクラスを書きなおして、１つのWeakReferenceの代わりに
 * WeeakHashMapを使用して返されたデータを保持するようにしなさい。
 */
public class DataHandler {
	private File lastFile;
	private WeakHashMap<byte[], Object> lastData;
	
	byte[] readFile(File file){
		byte[] data = null;
		
		//データを記憶しているか調べる
		if (file.equals(lastFile)){
			//data = lastData.
			if (data != null){
				return data;
			}
		}
		
		//記憶していないので、読みこむ
		data = readBytesFromFile(file);
		lastFile = file;
		lastData.put(data, null);
		return data;
	}
	
	byte[] readBytesFromFile(File file){
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
