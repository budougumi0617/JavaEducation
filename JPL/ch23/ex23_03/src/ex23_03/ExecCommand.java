/**
 * @file
 * @par File Name:
 * ExecCommand.java
 * @author budougumi0617
 * @date Created on 2014/02/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author budougumi0617
 * @note コマンドラインの引数に対して、execを実行して、コマンドから出力を表示する プログラムを作成しなさい。各出力行の前には行番号を表示しなさい。
 *       出力中に特定の文字列が現れたらそのコマンドを終了させるようにしなさい。
 */
public class ExecCommand {
	String[] execCommand(String cmd, String endCondition) {
		List<String> lines = new ArrayList<String>();
		try {
			String[] cmdArray = { cmd, "", "" };
			Process child = Runtime.getRuntime().exec(cmdArray);
			InputStream cmdOut = child.getInputStream();
			InputStreamReader r = new InputStreamReader(cmdOut);
			BufferedReader in = new BufferedReader(r);

			String line;
			int count = 0;
			while ((line = in.readLine()) != null) {
				lines.add(count + " : " + line);
				count++;
				if (line.indexOf(endCondition) != -1) {
					child.destroy();
					throw new InterruptedException("Command Finish");
				}
			}
			if (child.waitFor() != 0) {
				throw new IOException("command faild");
			}
			return lines.toArray(new String[0]);
		} catch (InterruptedException e) {
			
			System.out.println(e.toString());
			return lines.toArray(new String[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ExecCommand ec = new ExecCommand();
		String[] result = ec.execCommand("ipconfig", "Windows");
		System.out.println("Command Result");
		for (String line : result) {
			System.out.println(line);
		}
	}
}
