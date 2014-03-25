/*
 * @file
 * @par File Name:
 * UniteStream.java
 * @author budougumi0617
 * @date Created on 2014/03/25
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author budougumi0617
 * @note plugTogetherメソッドを作成しなさい。スレッドを作成する必要があるでしょう。
 */
public class UniteStream extends Thread {

	private InputStream in;
	private OutputStream out;

	public UniteStream(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	public static void main(String args[]) {
		try {
			userProg("ipconfig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 親のプロセスの標準ストリームを子プロセスの標準ストリームに結びつける
	 */
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	public static void plugTogether(InputStream in, OutputStream out) {
		new UniteStream(in, out).start();
	}

	public static void plugTogether(OutputStream out, InputStream in) {
		new UniteStream(in, out).start();
	}

	@Override
	public void run() {
		try {
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}

}