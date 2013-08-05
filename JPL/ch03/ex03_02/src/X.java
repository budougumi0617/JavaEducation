
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	private static int step = 0;

	public X(){
		PrintStep();
		fullMask = xMask;
		PrintStep();
	}

	public int mask(int orig){
		return (orig & fullMask);
	}

	public void PlusStep(){
		step++;
	}

	public int GetStep(){
		return step;
	}

	public int GetfullMask(){
		return fullMask;
	}
	public int GetxMask(){
		return xMask;
	}
	public void PrintStep(){
		System.out.printf("%-2d 0x%04x 0x%04x \n", step, GetxMask(), GetfullMask());
		PlusStep();
	}

}
