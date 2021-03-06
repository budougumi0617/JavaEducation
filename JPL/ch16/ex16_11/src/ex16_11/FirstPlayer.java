/*
 * @file
 * @par File Name:
 * FirstPlayer.java
 * @author z00s000723
 * @date Created on 2013/12/18
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_11;

/**
 * @author z00s000723
 * 
 */
public class FirstPlayer implements Player {
	Player targetPlayer;
	Game game;
	public void setGame(Game game){
		this.game = game;
	}
	public void setTargetPlayer(Player target){
		targetPlayer = target;
	}

	@Override
	public int play(int n) {
		int i, v, value = Game.MIN_VALUE;
		for (i = 0; i < Game.SIZE; i++) {
			if (Game.board[i] != Game.FREE)
				continue;
			/* MARU を書く */
			Game.board[i] = Game.MARU;
			/* 勝敗の判定 */
			v = game.checkWinner();
			/* 決着していなければ相手の手番へ */
			if (v == Game.DRAW && n < Game.SIZE - 1)
				v = targetPlayer.play(n + 1);
			/* ミニマックス */
			if (v > value)
				value = v;
			/* 元に戻す */
			Game.board[i] = Game.FREE;
		}
		return value;
	}

}
