class Solution {
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int N, K;
	static int[][] board;
	
	static int dfs(int row, int col, int depth, boolean hasCut, boolean[][] isVisited) {
		int max = depth;
		
		for (int[] d : DIRECTIONS) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc]) continue;
			isVisited[nr][nc] = true;
			
			if (board[nr][nc] < board[row][col]) {
				max = Math.max(dfs(nr, nc, depth + 1, hasCut, isVisited), max);
			} else if (!hasCut && board[nr][nc] - K < board[row][col]) {
				int tmp = board[nr][nc];

				// 최대 공사 깊이 -> 꼭 K 만큼 깎을 필요 없음
				board[nr][nc] = board[row][col] - 1;
				max = Math.max(dfs(nr, nc, depth + 1, !hasCut, isVisited), max);
				board[nr][nc] = tmp;
			}
			
			isVisited[nr][nc] = false;
		}
		
		return max;
	}
	
	static int getLongestTrail(int maxHeight) {
		int longestTrail = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[row][col] == maxHeight) {
					boolean[][] isVisited = new boolean[N][N];
					
					isVisited[row][col] = true;
					longestTrail = Math.max(dfs(row, col, 1, false, isVisited), longestTrail);
					isVisited[row][col] = false;
				}
			}
		}
		
		return longestTrail;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
    public static void main(String[] arge) throws Exception {
    	final int T = readInt();
    	StringBuilder result = new StringBuilder();
    	
    	for (int tc = 1; tc <= T; tc++) {
    		N = readInt();
        	K = readInt();
        	int maxHeight = 0;
        	board = new int[N][N];
        	
        	for (int row = 0; row < N; row++) {
        		for (int col = 0; col < N; col++) {
        			board[row][col] = readInt();
        			maxHeight = Math.max(board[row][col], maxHeight);
        		}
        	}
        	
        	result.append('#').append(tc).append(' ')
        		.append(getLongestTrail(maxHeight)).append('\n');
    	}
    	
    	System.out.print(result);
    }
}