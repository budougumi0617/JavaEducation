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
		PlayerLoader pl = new PlayerLoader();
		Class clazz = null;
		//Player player1 = new FirstPlayer(g);
		//Player player2 = new SecondPlayer(g);
		try {
			clazz = pl.findClass("ex16_11.FirstPlayer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Player player1 = null;
		try {
			player1 = (Player) clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try {
			clazz = pl.findClass("ex16_11.SecondPlayer");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Player player2 = null;
		try {
			player2 = (Player) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		player1.setTargetPlayer(player2);
		player1.setGame(g);
		player2.setTargetPlayer(player1);
		player2.setGame(g);
		int v, i, j;
		for (i = 0; i < SIZE; i++) {
			/* 初手 */
			board[i] = MARU;
			/* 相手の手番 */
			v =player2.play(1);
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




	static String getNextPlayer() {
		String name;
		switch (count) {
		case 0:
			name = "FirstPlayer";
			break;
		case 1:
			name = "SecondPlayer";
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
