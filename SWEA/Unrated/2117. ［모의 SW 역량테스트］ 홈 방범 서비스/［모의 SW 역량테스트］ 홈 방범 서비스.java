class Solution {
	static final int[] COSTS = {1, 5, 13, 25, 41, 61, 85, 113, 145, 181, 221, 265, 
			313, 365, 421, 481, 545, 613, 685, 761, 841};
	
	static int N, M;
	static boolean[][] city;
	
	static int getMaxRevenue(int midRow, int midCol) {
		int max = 0;
		
		for (int k = 0; k <= N; k++) {
			int offset = 0, house = 0;
			
			for (int row = midRow - k; row <= midRow + k; row++) {
				for (int col = midCol - offset; col <= midCol + offset; col++) {
					if (row < 0 || row >= N || col < 0 || col >= N || !city[row][col]) continue;
					house++;
				}
				
				if (row < midRow) offset++;
				else offset--;
			}
			
			if (house * M >= COSTS[k]) max = Math.max(house, max);
		}
		
		return max;
	}
	
	static int getMaxRevenue() {
		int max = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				max = Math.max(getMaxRevenue(row, col), max);
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
			city = new boolean[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					city[row][col] = readInt() == 1;
				}
			}
			
			result.append('#').append(tc).append(' ').append(getMaxRevenue()).append('\n');
		}
		
		System.out.print(result);
	}
}