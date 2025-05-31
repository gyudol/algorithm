class Solution {
	static int N, M, C;
	static int[][] honey;
	
	static int collect(int row, int srcCol, int desCol, int sum, int revenue) {
		if (sum > C) return 0;
		int max = revenue;
		
		for (int col = srcCol; col < desCol; col++) {
			int h = honey[row][col];
			
			max = Math.max(collect(row, col + 1, desCol, sum + h, revenue + h * h), max);
		}
		
		return max;
	}
	
	static int getMaxRevenue() {
		int max = 0;
		int[][] revenue = new int[N][N - M + 1];
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col <= N - M; col++) {
				revenue[row][col] = collect(row, col, col + M, 0, 0);
			}
		}
		
		for (int i = 0; i < N * N; i++) {
			if (i % N > N - M) continue;
			
			for (int j = i + M; j < N * N; j++) {
				if (j % N > N - M) continue;
				
				max = Math.max(revenue[i / N][i % N] + revenue[j / N][j % N], max);
			}
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
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			M = readInt();
			C = readInt();
			honey = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					honey[row][col] = readInt();
				}
			}
			
			result.append('#').append(tc).append(' ').append(getMaxRevenue()).append('\n');
		}
		
		System.out.print(result);
	}
}