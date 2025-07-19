class Main {
	static final int M = 3;
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		final int N = readInt();
		int[][] costs = new int[N][M];
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				costs[i][j] = readInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i + 1][j] = Integer.MAX_VALUE;
				
				for (int k = 0; k < M; k++) {
					if (j == k) continue;
					dp[i + 1][j] = Math.min(dp[i][k] + costs[i][k], dp[i + 1][j]);
				}
			}
		}
		
		System.out.print(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}