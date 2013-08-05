/*
 * @file
 * @par File Name:
 * SortMatrics.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex03_11;

final class SortMetrics implements Cloneable {
	public long probeCnt, compareCnt, swapCnt;

	/*
	 * public void init(){ probeCnt = compareCnt = swapCnt = 0; }
	 */
	final void stmetrics() {
		probeCnt = compareCnt = swapCnt = 0; // コンストラクタが呼べるのは一度だけ。
	}

	public String toString() {
		return probeCnt + "probes " + compareCnt + " compares " + swapCnt
				+ " swaps";
	}

	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

}
