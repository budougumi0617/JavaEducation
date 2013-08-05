
public class SortHarnessImpl implements SortHarness{
		private Object[] values;
		private final SortMetrics curMetrics = new SortMetrics();

		public final SortMetrics sort(Object[] data){
				values = data;
				//curMetrics.init(); //init()をコンストラクタ化する。
				doSort();
			return getMetrics();
		}

		public final SortMetrics getMetrics(){
			return curMetrics.clone();
		}
		public  int getDataLength(){
			return values.length;
		}

		public final Object probe(int i){
			curMetrics.probeCnt++;
			return values[i];
		}

		final int compare(int i, int j){
			curMetrics.compareCnt++;
			Comparable d1 = (Comparable) values[i];
			Comparable d2 = (Comparable) values[j];
			if((d1.compareTo(d2)) == 0)
				return 0;
			else
				return (d1.compareTo(d2) < 0? -1 : 1);
		}

		final void swap(int i, int j){
			curMetrics.swapCnt++;
			Object tmp = values[i];
			values[i] = values[j];
			values[j] = tmp;
		}

		public void doSort() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}
