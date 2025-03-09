import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N, M;
	static int[][] maze;
	
	static class State {
		int row, col, dist;
		
		State(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	
	static int bfs() {
		Queue<State> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
		
		q.offer(new State(0, 0, 1));
		isVisited[0][0] = true;
		
		while (!q.isEmpty()) {
			State state = q.poll();
			int row = state.row, col = state.col, dist = state.dist;
			
			if (row == N - 1 && col == M - 1) return dist;
			
			for (int[] d : DIR) {
				int nr = row + d[0], nc = col + d[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M
						|| isVisited[nr][nc] || maze[nr][nc] == 0) continue;
				isVisited[nr][nc] = true;
				q.offer(new State(nr, nc, dist + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		
		for (int row = 0; row < N; row++) {
			String line = br.readLine();
			
			for (int col = 0; col < M; col++) maze[row][col] = line.charAt(col) - '0';
		}
		
		System.out.print(bfs());
	}
}