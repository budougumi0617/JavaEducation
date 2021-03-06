/*
 * @file
 * @par File Name:
 * SortHarness.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex03_12;

public abstract class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(Object[] data) {
		values = data;
		// curMetrics.init(); //init()をコンストラクタ化する。
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	@SuppressWarnings("unchecked")
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		Comparable<Comparable<?>> d1 = (Comparable<Comparable<?>>) values[i];
		Comparable<?> d2 = (Comparable<?>) values[j];
		if ((d1.compareTo(d2)) == 0)
			return 0;
		else
			return (d1.compareTo(d2) < 0 ? -1 : 1);
	}

	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
}
