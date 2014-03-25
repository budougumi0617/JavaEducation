/*
 * @file
 * @par File Name:
 * PrintDate.java
 * @author budougumi0617
 * @date Created on 2014/03/25
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex24_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author budougumi0617
 * @note 文字列引数を取り、その文字列を解析して日付に変換して、その日付を可能な全てのスタイルで表示する
 *       プログラムを書きなさい。日付の解析はどの程度寛大ですか。
 */
public class PrintDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showDate("Tuesday, March 25, 2014 5:00:00 AM EDT");
		showDate("Aug 29, 2014 5:00:00 PM");
		showDate("8/29/14 5:00 PM");
		showDate("August -1, 2014 5:00:00 PM EDT");
		showDate("Friday, March 40, 2014 5:00:00 AM EDT");
	}

	@SuppressWarnings("serial")
	public static Map<Integer, String> formatPattern = new HashMap<Integer, String>() {
		{
			this.put(DateFormat.FULL, "Full");
			this.put(DateFormat.LONG, "Long");
			this.put(DateFormat.MEDIUM, "Medium");
			this.put(DateFormat.SHORT, "Short");
		}
	};
	

	
	
	public static Locale locale = new Locale("en", "US");

	public static void showDate(String source) {

		System.out.println(source);
		for (Entry<Integer, String> formatDate : formatPattern.entrySet()) {
			for (Entry<Integer, String> formatTime : formatPattern.entrySet()) {
				DateFormat fmt = DateFormat.getDateTimeInstance(
						formatDate.getKey(), formatTime.getKey(), locale);
				System.out.printf("  Date: %s\tTime: %s\t|",
						formatDate.getValue(), formatTime.getValue());
				Date date = null;
				try {
					date = fmt.parse(source);
					System.out.printf("%s", fmt.format(date));
				} catch (ParseException e) {
					System.out.printf(" Parse failed.");
				}
				System.out.println();
			}
		}
	}

	public static Date parseDate(DateFormat fmt, String source) {
		Date date = null;
		try {
			date = fmt.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return date;
	}
}
