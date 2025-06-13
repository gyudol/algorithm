import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static int N;
	static int[][] roads;
	
	static int dijkstra() {
		int[][] minDist = new int[N][N];
		PriorityQueue<State> pq = new PriorityQueue<>();
		
		pq.offer(new State(0, 0, 0));
		for (int row = 0; row < N; row++) {
			Arrays.fill(minDist[row], Integer.MAX_VALUE);
		}
		
		while (!pq.isEmpty()) {
			State state = pq.poll();
			int row = state.row, col = state.col, dist = state.dist;
			
			if (row == N - 1 && col == N - 1) return dist;
			
			for (int[] d : DIRECTIONS) {
				int nr = row + d[0], nc = col + d[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N 
						|| minDist[nr][nc] <= dist + roads[nr][nc]) continue;
				
				minDist[nr][nc] = dist + roads[nr][nc];
				pq.offer(new State(nr, nc, minDist[nr][nc]));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			roads = new int[N][N];
			
			for (int row = 0; row < N; row++) {
				int col = 0;
				
				for (char c : br.readLine().toCharArray()) {
					roads[row][col++] = c - '0';
				}
			}
			
			result.append('#').append(tc).append(' ').append(dijkstra()).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class State implements Comparable<State> {
		int row, col, dist;
		
		State(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(State other) {
			return Integer.compare(dist, other.dist);
		}
	}
}