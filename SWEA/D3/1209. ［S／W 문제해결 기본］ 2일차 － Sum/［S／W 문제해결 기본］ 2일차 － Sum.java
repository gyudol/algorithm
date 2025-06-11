class Solution {
	static final int T = 10;
	static final int N = 100;
	
	static int[][] board = new int[N][N];
	
	static int getMaxSumOfLines() {
		int max = Integer.MIN_VALUE;
		
		for (int row = 0; row < N; row++) {
			int sum = 0;
			
			for (int col = 0; col < N; col++) {
				sum += board[row][col];
			}
			
			max = Math.max(sum, max);
		}
		
		for (int col = 0; col < N; col++) {
			int sum = 0;
			
			for (int row = 0; row < N; row++) {
				sum += board[row][col];
			}

			max = Math.max(sum, max);
		}

		int rightDownDiagSum = 0, leftDownDiagSum = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (row == col) rightDownDiagSum += board[row][col];
				if (row + col == N) leftDownDiagSum += board[row][col];
			}
		}
		
		return Math.max(Math.max(rightDownDiagSum, leftDownDiagSum), max);
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		int tc = 0;
		StringBuilder result = new StringBuilder();
		
		while (tc < T) {
			tc = readInt();
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					board[row][col] = readInt();
				}
			}
			
			result.append('#').append(tc).append(' ')
				.append(getMaxSumOfLines()).append('\n');
		}
		
		System.out.print(result);
	}
}