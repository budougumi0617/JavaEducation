/**
 * @file
 * @par File Name:
 * ExecCommand.java
 * @author budougumi0617
 * @date Created on 2014/02/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author budougumi0617
 * @note コマンドラインの引数に対して、execを実行して、コマンドから出力を表示する
 *       プログラムを作成しなさい。各出力行の前には行番号を表示しなさい。
 *       出力中に特定の文字列が現れたらそのコマンドを終了させるようにしなさい。
 */
public class ExecCommand {
	String[] execCommand(String cmd) {
		cmd = "dir";
		try {
			String[] cmdArray = { cmd, "", "./" };
			Process child = Runtime.getRuntime().exec(cmdArray);
			InputStream cmdOut = child.getInputStream();
			InputStreamReader r = new InputStreamReader(cmdOut);
			BufferedReader in = new BufferedReader(r);

			List<String> lines = new ArrayList<String>();
			String line;
			int count = 0;
			while ((line = in.readLine()) != null) {
				lines.add(count + ":" + line);
			}
			if (child.waitFor() != 0) {
				throw new IOException("command faild");
			}
			count++;
			return lines.toArray(new String[0]);
		} catch (Exception e) {

		}
		return null;
	}

	public static void main(String[] args) {
		ExecCommand ec = new ExecCommand();
		System.out.println(ec.execCommand("test"));
	}
}
