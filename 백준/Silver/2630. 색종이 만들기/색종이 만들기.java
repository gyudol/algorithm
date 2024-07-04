import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class Count {
		public int zero;
		public int one;
		
		private Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
		
		private Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}
	
	private static Count compress(int [][] confetti, int srcRow, int srcCol, int width) {
		int last = confetti[srcRow][srcCol];
		
		for(int row = srcRow; row < srcRow + width; row++) {
			for(int col = srcCol; col < srcCol + width; col++) {
				if(last != confetti[row][col]) {
					int half = width / 2;
					
					return compress(confetti, srcRow, srcCol, half)
					.add(compress(confetti, srcRow, srcCol + half, half))
					.add(compress(confetti, srcRow + half, srcCol, half))
					.add(compress(confetti, srcRow + half, srcCol + half, half));
				}
			}
		}
		
		return last == 0 ? new Count(1, 0) : new Count(0, 1);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int [][] confetti = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) confetti[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Count count = compress(confetti, 0, 0, n);
		result.append(count.zero).append('\n').append(count.one);
		
		System.out.print(result);
	}
}
