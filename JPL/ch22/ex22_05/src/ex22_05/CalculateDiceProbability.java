/**
 * @file
 * @par File Name:
 * CalculateDiceProbability.java
 * @author budougumi0617
 * @date Created on 2014/01/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author budougumi0617
 *         6面のサイコロの個数が指定されると、可能性のある合計値ごとに
 *         理論的な確率を計算できます
 *         。たとえば、2個の6面サイコロでは、合計が7になる確率は、
 *         1/6です。プログラムを作成して
 *         、特定の個数の6面サイコロでの合計値の理論的分布を、
 *         1から6までの数を発生するRandomを使用して膨大な数のサイコロを
 *         「振った」結果と
 *         比較しなさい。どの乱数発生メソッドを使用するかは、問題となりますか。
 * 
 *         参考：http://bal4u.dip.jp/cpc/2005/04/post
 *         -17.html
 */
public class CalculateDiceProbability {
	static final int MAX = 10;
	int diceCount;
	List<Integer> countResultList;
	List<Integer> randomResultList;
	Dice dice;

	/**
	 * 
	 */
	public CalculateDiceProbability(int n) {
		diceCount = n;
		countResultList = new ArrayList<Integer>(6 * diceCount
				- (diceCount - 1));
		randomResultList = new ArrayList<Integer>(6 * diceCount
				- (diceCount - 1));
		dice = new Dice();
	}

	int computeDiceSum() {
		int result = 0;
		for (int i = 0; i < diceCount; i++) {
			result += dice.roll();
		}
		return result;
	}

	void computeResult() {
		for (int i = 0; i < 6 * diceCount - (diceCount - 1); i++) {
			countResultList.add(i, (int) S(diceCount, i + diceCount));
		}
	}

	void computeRandomResult() {
		int result = 0;
		for (int i = 0; i < 6 * diceCount - (diceCount - 1); i++) {
			randomResultList.add(0, 0);
		}
		for (int i = 0; i < 10000; i++) {
			result = computeDiceSum() - diceCount;
			randomResultList.set(result, randomResultList.get(result) + 1);
		}
	}

	public String printResultValue(int n) {
		return ((double) countResultList.get(n).intValue() / (Math.pow(6,
				diceCount)))
				* 100
				+ "\t"
				+ ((double) randomResultList.get(n).intValue());// / 10000) * 100;
	}

	public void printResultValue() {
		System.out.println("サイコロの数：" + diceCount);
		System.out.println("合計値:\t分布\t結果");
		for (int i = 0; i < 6 * diceCount - (diceCount - 1); i++) {
			System.out
					.printf("%3d : %6.2f\t%6.2f\n",
							i + diceCount,
							((double) countResultList.get(i).intValue() / (Math
									.pow(6, diceCount))) * 100,
							((double) randomResultList.get(i).intValue() / 10000) * 100);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 3;
		CalculateDiceProbability cdp = new CalculateDiceProbability(N);
		cdp.computeResult();
		cdp.computeRandomResult();
		cdp.printResultValue();

	}

	/**
	 * N 個のサイコロをいっぺんにふったとき，出た目の和 K になる組合せの数を 関数
	 * S(N,K)
	 * 
	 * @param N
	 *            サイコロの数
	 * @param K
	 *            計算したい出た目の和
	 * @return 組み合わせの数
	 */
	public long S(int N, int K) {
		int i, j, k;
		long s;
		long[][] tbl = new long[MAX + 1][6 * MAX + 1];

		if (K < N || K > 6 * N) {
			return 0;
		}
		if (N > MAX) {
			return -1;
		}
		for (i = 0; i < MAX + 1; i++) {
			for (j = 0; j < 6 * MAX + 1; j++) {
				tbl[i][j] = 0;
			}
		}
		for (i = 1; i <= 6; i++) {
			tbl[1][i] = 1;
		}
		for (i = 2; i <= N; i++) {
			for (j = i; j <= 6 * i; j++) {
				for (k = 1, s = 0; k <= 6; k++) {
					if (j >= k)
						s += tbl[i - 1][j - k];
				}
				tbl[i][j] = s;
			}
		}
		return tbl[N][K];
	}
}
