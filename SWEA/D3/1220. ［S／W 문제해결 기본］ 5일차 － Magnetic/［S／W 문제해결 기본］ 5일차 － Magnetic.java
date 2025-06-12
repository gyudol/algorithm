class Solution {
	static final int T = 10;
	
	static int N;
	static int[][] board;
	
	static int getDeadlockCount() {
		int cnt = 0;
		
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row++) {
				if (board[row][col] == 1) {
					int nr = row + 1;
					
					while (nr < N && board[nr][col] != 2) nr++;
					if (nr >= N) break;
					
					while (nr < N && board[nr][col] != 1) nr++;
					
					cnt++;
					row = nr - 1;
				}
			}
		}
		
		return cnt;
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
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			board = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					board[row][col] = readInt();
				}
			}
			
			result.append('#').append(tc).append(' ').append(getDeadlockCount()).append('\n');
		}
		
		System.out.print(result);
	}
}