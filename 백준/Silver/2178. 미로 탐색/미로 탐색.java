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
	
	private static class State {
		public int row;
		public int col;
		public int depth;
		
		private State(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
	
	private static int bfs(int [][] maze, boolean [][] isVisited) {
		Queue<State> q = new LinkedList<>();
		q.offer(new State(0, 0, 1));
		isVisited[0][0] = true;
		
		while(!q.isEmpty()) {
			State s = q.poll();
			
			if(s.row == n - 1 && s.col == m - 1) return s.depth;
			
			for(int [] d : DIR) {
				int nextRow = s.row + d[0];
				int nextCol = s.col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m
						|| maze[nextRow][nextCol] == 0 || isVisited[nextRow][nextCol]) continue;
				
				isVisited[nextRow][nextCol] = true;
				q.offer(new State(nextRow, nextCol, s.depth + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		int [][] maze = new int [n][m];
		
		for(int i = 0; i < n; i++)
			maze[i] = Arrays.stream(br.readLine().split(""))
					.mapToInt(Integer::parseInt).toArray();
		
		System.out.print(bfs(maze, new boolean [n][m]));
	}
}