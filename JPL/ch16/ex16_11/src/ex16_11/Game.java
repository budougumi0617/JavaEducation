/*
 * @file
 * @par File Name:
 * Game.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_11;

/**
 * GameクラスとPlayerクラスを発展させて、三目並べのような簡単なゲームを実装しなさい。
 * いくつかのPlayerの実装を、それぞれ何回か実行して、スコアーを取りなさい。
 * 
 * 
 */
public class Game {
	static int count = 0;
	static final int SIZE = 9;
	static final int FREE = 0;
	static final int MARU = 1;
	static final int BATU = 5;
	static final int LINE = 8;
	static final int MARU_WIN = 1;
	static final int BATU_WIN = 5;
	static final int DRAW = 0;
	static final int MAX_VALUE = 2;
	static final int MIN_VALUE = (-2);

	/* 盤面 */
	static char board[];
	char[][] line = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 },
			{ 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 }, };

	public Game() {
		board = new char[SIZE];

	}

	public static void main(String[] args) {
		/*
		 * String name; // Class name while ((name = getNextPlayer()) != null) {
		 * try { PlayerLoader loader = new PlayerLoader(); } catch (Exception e)
		 * { reportException(name, e); } }
		 */
		Game g = new Game();
		int v, i, j;
		for (i = 0; i < SIZE; i++) {
			/* 初期化 */
		
			/* 初手 */
			board[i] = MARU;
			/* 相手の手番 */
			v = g.thinkBatu(1);
			/* 結果 */
			System.out.printf("初手 %d: 評価値 %d\n", i, v);
		}
		return;

	}

	int checkWinner() {
		int i;
		for (i = 0; i < LINE; i++) {
			int piece = board[line[i][0]];
			if (piece != FREE && piece == board[line[i][1]]
					&& piece == board[line[i][2]]) {
				return (piece == MARU ? MARU_WIN : BATU_WIN);
			}
		}
		return DRAW;
	}

	/* 先手 */
	int thinkMaru(int n) {
		int i, v, value = MIN_VALUE;
		for (i = 0; i < SIZE; i++) {
			if (board[i] != FREE)
				continue;
			/* MARU を書く */
			board[i] = MARU;
			/* 勝敗の判定 */
			v = checkWinner();
			/* 決着していなければ相手の手番へ */
			if (v == DRAW && n < SIZE - 1)
				v = thinkBatu(n + 1);
			/* ミニマックス */
			if (v > value)
				value = v;
			/* 元に戻す */
			board[i] = FREE;
		}
		return value;
	}

	/* 後手 */
	int thinkBatu(int n) {
		int i, v, value = MAX_VALUE;
		for (i = 0; i < SIZE; i++) {
			if (board[i] != FREE)
				continue;
			/* BATU を書く */
			board[i] = (char) BATU;
			/* 勝敗の判定 */
			v = checkWinner();
			/* 決着していなければ相手の手番へ */
			if (v == DRAW && n < SIZE - 1)
				v = thinkMaru(n + 1);
			/* ミニマックス */
			if (v < value)
				value = v;
			/* 元に戻す */
			board[i] = FREE;
		}
		return value;
	}

	static String getNextPlayer() {
		String name;
		switch (count) {
		case 0:
			name = "first";
			break;
		case 1:
			name = "second";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}

	static void reportException(String name, Exception e) {
		System.out.println("error name = " + name.toString());
		e.printStackTrace();
	}
}
