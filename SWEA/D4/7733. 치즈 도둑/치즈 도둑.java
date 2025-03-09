class Solution {
	static final int MAX_VALUE = 100;
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N;
	static int[][] cheese;
	static boolean[][] isVisited;
	
	static boolean eatCheese(int row, int col, int x) {
		if (isVisited[row][col] || cheese[row][col] <= x) return false;
		isVisited[row][col] = true;
		
		for (int[] d : DIR) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			eatCheese(nr, nc, x);
		}
		
		return true;
	}
	
	static int countGroups() {
		int max = 1;	// x == 0
		
		for (int x = 1; x < MAX_VALUE; x++) {
			int cnt = 0;
			isVisited = new boolean[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (eatCheese(row, col, x)) cnt++;
				}
			}
			
			max = Math.max(cnt, max);
		}
		
		return max;
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
		final int T = readInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			cheese = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) cheese[row][col] = readInt();
			}
			
			result.append('#').append(tc).append(' ').append(countGroups()).append('\n');
		}
		
		System.out.print(result);
	}
}