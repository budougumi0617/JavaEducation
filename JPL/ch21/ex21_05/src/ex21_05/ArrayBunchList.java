/**
 * @file
 * @par File Name:
 * ArrayBunchList.java
 * @author budougumi0617
 * @date Created on 2014/01/04
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_05;

import java.util.AbstractList;

import sun.security.util.Length;

/**
 * @author budougumi0617
 * 
 */
public class ArrayBunchList<E> extends AbstractList<E> {
	private final E[][] arrays;
	private final int size;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array : arrays) {
			s += array.length;
		}
		size = s;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public E get(int index) {
		int off = 0; // コレクションの先頭からのオフセット
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length) {
				return arrays[i][index - off];
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return size;
	}

	public E set(int index, E value) {
		int off = 0; // コレクションの先頭からのオフセット
		for (int i = 0; i < arrays.length; i++) {
			E ret = arrays[i][index - off];
			arrays[i][index - off] = value;
			return ret;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

}
