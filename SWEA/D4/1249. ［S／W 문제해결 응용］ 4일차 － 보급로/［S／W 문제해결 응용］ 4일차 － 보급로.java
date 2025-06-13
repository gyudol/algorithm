import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int N;
	static int[][] roads;
	static int[][] isVisited;
	static int min;
	
	static void dfs(int row, int col, int cost) {
		if (row == N - 1 && col == N - 1) min = Math.min(cost, min);
		if (cost >= min) return;
		
		for (int[] d : DIRECTIONS) {
			int nr = row + d[0], nc = col + d[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N 
					|| isVisited[nr][nc] <= cost + roads[nr][nc]) continue;
			
			isVisited[nr][nc] = cost + roads[nr][nc];
			dfs(nr, nc, cost + roads[nr][nc]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			roads = new int[N][N];
			isVisited = new int[N][N];
			min = Integer.MAX_VALUE;
			
			for (int row = 0; row < N; row++) {
				int col = 0;
				
				Arrays.fill(isVisited[row], Integer.MAX_VALUE);
				for (char c : br.readLine().toCharArray()) {
					roads[row][col++] = c - '0';
				}
			}
			
			isVisited[0][0] = 0;
			dfs(0, 0, 0);
			
			result.append('#').append(tc).append(' ').append(min).append('\n');
		}
		
		System.out.print(result);
	}
}