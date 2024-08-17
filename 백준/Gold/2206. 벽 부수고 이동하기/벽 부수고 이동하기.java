import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static int m;
	private static int [][] map;
	
	private static class State {
		private int row;
		private int col;
		private int dist;
		private int hasBrokenWall;
		
		private State(int row, int col, int dist, int hasBrokenWall) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.hasBrokenWall = hasBrokenWall;
		}
	}
	
	private static int bfs() {
		Queue<State> q = new LinkedList<>();
		boolean [][][] isVisited = new boolean [n][m][2];
		
		q.offer(new State(0, 0, 1, 0));
		isVisited[0][0][0] = isVisited[0][0][1] = true;
		
		while(!q.isEmpty()) {
			State state = q.poll();
			int row = state.row, col = state.col, dist = state.dist;
			
			if(row == n - 1 && col == m - 1) return dist;
			
			for(int [] d : DIR) {
				int nextRow = row + d[0], nextCol = col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m
						|| (state.hasBrokenWall == 1 && map[nextRow][nextCol] == 1)) continue;
				
				int nextHasBrokenWall = map[nextRow][nextCol] == 1 ? 1 : state.hasBrokenWall;
				
				if(isVisited[nextRow][nextCol][nextHasBrokenWall]) continue;
				isVisited[nextRow][nextCol][nextHasBrokenWall] = true;
				q.offer(new State(nextRow, nextCol, dist + 1, nextHasBrokenWall));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			int j = 0;
			
			for(char c : br.readLine().toCharArray()) map[i][j++] = c - '0';
		}
		
		System.out.print(bfs());
	}
}