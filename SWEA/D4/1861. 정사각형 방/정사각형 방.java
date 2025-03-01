class Solution {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N;
	static int[] dp;
	static int[][] rooms;
	
	static int getRoomDist(int row, int col) {
		int num = rooms[row][col];
		
		if(num >= dp.length) return 0;
		if(dp[num] != 0) return dp[num];
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow >= 0 && nextRow < N && nextCol >= 0 &&
					nextCol < N && rooms[nextRow][nextCol] == num + 1)
				return dp[num] = getRoomDist(nextRow, nextCol) + 1;
		}
		
		return dp[num] = 1;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while((c = System.in.read()) <= 32);
		
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder result = new StringBuilder();
		final int T = readInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = readInt();
			rooms = new int[N][N];
			dp = new int[N * N + 1];
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) rooms[row][col] = readInt();
			}

			int maxRoom = -1, maxDist = -1;
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					int dist = getRoomDist(row, col);
					
					if(dist == maxDist) maxRoom = Math.min(rooms[row][col], maxRoom);
					else if(dist > maxDist) {
						maxRoom = rooms[row][col];
						maxDist = dist;
					}
				}
			}

			result.append('#').append(tc).append(' ')
				.append(maxRoom).append(' ').append(maxDist).append('\n');
		}
		
		System.out.print(result);
	}
}