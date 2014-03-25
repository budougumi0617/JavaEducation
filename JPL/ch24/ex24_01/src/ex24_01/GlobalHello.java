package ex24_01;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author budougumi0617
 * @note GlobalHelloを、例として挙げたロケールで動かしてみなさい。LIstResorceBundle、
 *       .propertiesファイル、それにResourceBandleのサブクラスを作成して、ロケールをいくつか追加しなさい。
 * @note http://itpro.nikkeibp.co.jp/article/COLUMN/20071102/286260/
 * @note http://d.hatena.ne.jp/simply-k/20100721/1279748122
 * @note http://itpro.nikkeibp.co.jp/article/COLUMN/20071102/286295/
 * @note \ex24_01\src>javac -encoding UTF8 ex24_01\*.java
 *       \ex24_01\src>javac -encoding UTF8 ex24_01\*.java
 *       \ex24_01\src>java ex24_01.GlobalHello test en Good bye!
 */
public class GlobalHello {

	public static void main(String[] args) {
		ResourceBundle res = ResourceBundle.getBundle("ex24_01.GlobalRes",
				Locale.US);
		/*
		 * ResourceBundle.Control
		 * .getControl(ResourceBundle.Control.FORMAT_PROPERTIES));
		 */
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalRes.GOODBYE);
		} else {
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(res.getLocale().toString());
		System.out.println(msg);

	}

}
