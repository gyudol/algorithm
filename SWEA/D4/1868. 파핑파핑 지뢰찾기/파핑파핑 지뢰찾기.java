import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	private static final int[][] DIR = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, 
			{1, -1}, {0, -1}, {-1, -1}};
	
	private static class State implements Comparable<State> {
		private int row;
		private int col;
		private int value;
		
		private State(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
		
		@Override
		public int compareTo(State other) {
			return Integer.compare(value, other.value);
		}
	}
	
	private static int mineCnt(int row, int col, int N, char[][] board) {
		int cnt = 0;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
					|| board[nextRow][nextCol] == '.') continue;
			
			cnt++;
		}
		
		return cnt;
	}
	
	private static void dfs(int row, int col, int N, boolean[][] isVisited, char[][] board) {
		if(isVisited[row][col]) return;
		isVisited[row][col] = true;
		
		if(mineCnt(row, col, N, board) > 0) return;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
					|| board[nextRow][nextCol] == '*') continue;
			
			dfs(nextRow, nextCol, N, isVisited, board);
		}
	}
	
	private static int bfs(int N, char[][] board) {
		PriorityQueue<State> pq = new PriorityQueue<>();
		boolean[][] isVisited = new boolean[N][N];
		int cnt = 0;
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] == '*') {
					isVisited[row][col] = true;
					continue;
				}
				
				int mineCnt = 0;
				
				for(int[] d : DIR) {
					int nextRow = row + d[0], nextCol = col + d[1];
					
					if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N
							|| board[nextRow][nextCol] == '.') continue;
					mineCnt++;
				}
				
				pq.offer(new State(row, col, mineCnt));
			}
		}
		
		while(!pq.isEmpty()) {
			State state = pq.poll();
			int row = state.row, col = state.col;
			
			if(isVisited[row][col]) continue;
			
			dfs(row, col, N, isVisited, board);
			cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			
			for(int row = 0; row < N; row++) board[row] = br.readLine().toCharArray();
			
			result.append('#').append(tc).append(' ').append(bfs(N, board)).append('\n');
		}
		
		System.out.print(result);
	}
}