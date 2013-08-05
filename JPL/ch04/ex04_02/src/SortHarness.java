
interface SortHarness {

		public SortMetrics sort(Object[] data);

		public SortMetrics getMetrics();
		int getDataLength();

		Object probe(int i);
		int compare(int i, int j);

		void swap(int i, int j);
		void doSort();
	}
