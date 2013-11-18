/*
 * @file
 * @par File Name:
 * Foo.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex16_02;

class Foo implements Runnable {
	// 内部クラス
	class Bar {
		private int x;

		Bar() {
		}

		Bar(int x) {
			this.x = x;
		}

		int get_x() {
			return x;
		}

		int get_y() {
			return y;
		} // Foo のインスタンス変数にアクセスできる

		int get_yy() {
			return yy;
		} // Foo のクラス変数にもアクセスできる
	}

	private int y;
	static private int yy = 1;

	Foo() {
	}

	Foo(int y) {
		this.y = y;
	}

	static int get_x(Bar z) {
		return z.x;
	}

	public void run() {
		// TODO 自動生成されたメソッド・スタブ

	}
}