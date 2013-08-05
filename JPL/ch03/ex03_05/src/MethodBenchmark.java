
public class MethodBenchmark extends Benchmark{
	@Override
	void benchmark() {
		for(int i = 0; i < 100; i++);
	}

	public static void main(String[] args) {
		int count = 10;
		long time = new MethodBenchmark().repeat(count);
		System.out.println("Benchmark Result: count = " + count
				+ " time = "  + time + " nano sec");
	}



}
