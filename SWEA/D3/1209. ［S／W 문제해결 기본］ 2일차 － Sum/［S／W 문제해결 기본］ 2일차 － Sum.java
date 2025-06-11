class Solution {
	static final int T = 10;
	static final int N = 100;
	
	static int[][] board = new int[N][N];
	
	static int getMaxSumOfLines() {
		int max = Integer.MIN_VALUE;
		int leftDownDiagSum = 0, rightDownDiagSum = 0;
		
		for (int i = 0; i < N; i++) {
			int rowSum = 0, colSum = 0;
			
			for (int j = 0; j < N; j++) {
				rowSum += board[i][j];
				colSum += board[j][i];
			}
			
			max = Math.max(Math.max(rowSum, colSum), max);
			rightDownDiagSum += board[i][i];
			leftDownDiagSum += board[i][N - i - 1];
		}
		
		return Math.max(Math.max(leftDownDiagSum, rightDownDiagSum), max);
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