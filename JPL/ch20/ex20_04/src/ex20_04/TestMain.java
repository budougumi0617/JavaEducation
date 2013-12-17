package ex20_04;

import java.io.IOException;
import java.io.StringReader;

public class TestMain {

	public static void main(String[] args) throws IOException {

		String ls = System.getProperty("line.separator");

		StringBuffer sb = new StringBuffer();

		sb.append("PrintLine ");
		sb.append("don't ");
		sb.append("stop ");
		sb.append("to read() ");
		sb.append("until endline");
		sb.append(ls);
		sb.append("2 Line ");
		sb.append(ls);
		sb.append("3 Line ");
		sb.append(ls);
		sb.append("if ");
		sb.append("get endline, ");
		sb.append("readLine() can't ");
		sb.append("finish");

		StringReader sr = new StringReader(sb.toString());
		PrintLine pl = new PrintLine(sr);
		// LineReader lr = new LineReader(new InputStreamReader(System.in));

		// １行目
		System.out.println(pl.readLine());

		// ２行目
		System.out.println(pl.readLine());

		// ３行目
		System.out.println(pl.readLine());

	}

}
