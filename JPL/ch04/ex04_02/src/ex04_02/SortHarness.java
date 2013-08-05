/*
 * @file
 * @par File Name:
 * SortHarness.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex04_02;

interface SortHarness {

	public SortMetrics sort(Object[] data);

	public SortMetrics getMetrics();

	int getDataLength();

	Object probe(int i);

	int compare(int i, int j);

	void swap(int i, int j);

	void doSort();
}
