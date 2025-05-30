class Solution {
	static final int UNREACHABLE = -1;
	static final int M = 100;
	static final int[][] DIR = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static int N;
	static int[][] desserts;
	static boolean[] isSelected;
	
	static int dfs(int r, int c, int d, int tr, int tc, int dist) {
		if (r < 0 || r  >= N || c < 0 || c >= N 
				|| d == DIR.length || isSelected[desserts[r][c]]) return UNREACHABLE;
		
		if (r == tr && c == tc) return dist;
		
		isSelected[desserts[r][c]] = true;
		int nr = r + DIR[d][0], nc = c + DIR[d][1], max = UNREACHABLE;
		
		max = Math.max(dfs(nr, nc, d, tr, tc, dist + 1), 
				Math.max(dfs(nr, nc, d + 1, tr, tc, dist + 1), max));
		
		isSelected[desserts[r][c]] = false;
		return max;
	}
	
	static int getMaxItem() {
		int max = UNREACHABLE;
		isSelected = new boolean[M + 1];
		
		for (int row = 0; row <= N - 3; row++) {
			for (int col = 0; col <= N - 1; col++)
				max = Math.max(dfs(row, col, 0, row + 1, col - 1, 1), max);
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
			desserts = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++)
					desserts[row][col] = readInt();
			}
			
			result.append('#').append(tc).append(' ').append(getMaxItem()).append('\n');
		}
		
		System.out.print(result);
	}
}