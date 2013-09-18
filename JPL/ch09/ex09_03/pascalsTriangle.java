/**
*ÇøÇÂÇ¡Ç∆ÇÌÇ©ÇËÇ‹ÇπÇÒÇ≈ÇµÇΩÅB
*/

public class pascalsTriangle {
	private int pascal[][];
	public pascalsTriangle(int num) {
		pascal = new int[num][];
		for(int i=0,j=0;i<pascal.length;i++){
			pascal[i] = new int[i+1];
			pascal[i][j]=1;
			pascal[i][i]=1;
		}
		calc();
	}
	public int[][] calc(){
		for(int j=2;j<pascal.length;j++)
			for(int i=1;i<pascal[j].length-1;i++)
				pascal[j][i]=pascal[j-1][i-1]+pascal[j-1][i];
		return pascal;
	}
	public void show(){
		for (int[] array : pascal) {
			for (int i : array)
				System.out.printf(" %d ", i);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		pascalsTriangle pt = new pascalsTriangle(12);
		pt.show();
		pt = new pascalsTriangle(5);
		pt.show();
	}
}