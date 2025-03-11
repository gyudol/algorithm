class Main {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static final int R = 3;
	static int N, M;
	static int[][] lab;
	static int max = 0;
	
	static boolean dfs(int row, int col, boolean[][] isVisited) {
		if (isVisited[row][col]) return false;
		isVisited[row][col] = true;
		
		for (int[] d : DIR) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || lab[nr][nc] == 1) continue;
			dfs(nr, nc, isVisited);
		}
		
		return true;
	}
	
	static int getSafeArea() {
		int areaCnt = 0;
		boolean[][] isVisited = new boolean[N][M];
		
		for (int row = 0; row < N; row++) {		// virus infection
			for (int col = 0; col < M; col++) {
				if (lab[row][col] == 2) dfs(row, col, isVisited);
			}
		}
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (lab[row][col] == 0 && !isVisited[row][col]) areaCnt++;
			}
		}
		
		return areaCnt;
	}
	
	static void comb(int src, int depth) {
		if (depth == R) {
			max = Math.max(getSafeArea(), max);
			return;
		}
		
		for (int i = src; i < N * M; i++) {
			int tmp = lab[i / M][i % M];
			
			if (tmp != 0) continue;
			
			lab[i / M][i % M] = 1;
			comb(i + 1, depth + 1);
			lab[i / M][i % M] = tmp;
		}
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String [] args) throws Exception {
		N = readInt();
		M = readInt();
		lab = new int[N][M];
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) lab[row][col] = readInt();
		}
		
		comb(0, 0);
		System.out.print(max);
	}
}