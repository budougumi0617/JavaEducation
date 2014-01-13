import java.util.Comparator;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/*
 * @file
 * @par File Name:
 * ColumnResizer.java
 * @author budougumi0617
 * @date Created on 2014/01/06
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

public class SorttableTableModel implements TableModel,TableModelListener {
	
	EventListenerList listenerList = new EventListenerList();
	TableModel delegateModel;
	int[] sortedIndicies;
	int sortColumn;
	@SuppressWarnings("rawtypes")
	Comparator comparator;
	@SuppressWarnings("rawtypes")
	Comparator[] comparators;

	public SorttableTableModel(TableModel tm){
		delegateModel = tm;
		delegateModel.addTableModelListener(this);
		comparators = new Comparator[tm.getColumnCount()];
		sortedIndicies = new int[10];
		setSortColumn(0);
	}
	
	
	/**
	 * 現在のComparatorをnullにリセット
	 * これにより「自然な順序付け」がソート処理で使われる
	 */
	private void setSortColumn(int i) {
		sortColumn = 0;

		comparator = null;
		if((comparators != null) && (comparators.length > 0)){
			comparator = comparators[sortColumn];
		}
		resort();
	}


	/**
	 * P122参照のこと
	 */
	protected void resort() {
		// TODO 自動生成されたメソッド・スタブ
		
	}


	@Override
	public int getRowCount() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
