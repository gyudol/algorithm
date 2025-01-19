import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private static class State implements Comparable<State> { 
		private int row;
		private int col;
		private int time;
		
		private State(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
		
		@Override
		public int compareTo(State other) {
			return Integer.compare(time, other.time);
		}
	}
	
	private static int bfs(int N, int[][] sea, int[][] points) {
		boolean[][] isVisited = new boolean[N][N];
		PriorityQueue<State> pq = new PriorityQueue<>();
		int srcRow = points[0][0], srcCol = points[0][1];
		
		pq.offer(new State(srcRow, srcCol, 0));
		isVisited[srcRow][srcCol] = true;
		
		while(!pq.isEmpty()) {
			State state = pq.poll();
			int row = state.row, col = state.col, time = state.time;
			
			if(row == points[1][0] && col == points[1][1]) return time;
			
			for(int[] d : DIR) {
				int nextRow = row + d[0], nextCol = col + d[1];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
						|| isVisited[nextRow][nextCol] || sea[nextRow][nextCol] == 1) continue;
				
				if(sea[nextRow][nextCol] == 2 && time % 3 != 2) 
					pq.offer(new State(nextRow, nextCol, time + (time % 3 == 0 ? 3 : 2)));
				else pq.offer(new State(nextRow, nextCol, time + 1));
				
				isVisited[nextRow][nextCol] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			int[][] sea = new int[N][N];
			int[][] points = new int[2][2];
			
			for(int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) sea[row][col] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < points.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < points[i].length; j++) points[i][j] = Integer.parseInt(st.nextToken());
			}
			
			result.append('#').append(tc).append(' ').append(bfs(N, sea, points)).append('\n');
		}
		
		System.out.print(result);
	}
}