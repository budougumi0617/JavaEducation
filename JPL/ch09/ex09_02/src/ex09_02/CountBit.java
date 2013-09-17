package ex09_02;

public class CountBit {
	public static int CheckBitCount(Integer n) {
		int Counter = 0;
		for (int j = 0; j < Integer.SIZE; j++) {
			Counter += (n & 1);
			n = n >>> 1;
		}
		return Counter;
	}

}
