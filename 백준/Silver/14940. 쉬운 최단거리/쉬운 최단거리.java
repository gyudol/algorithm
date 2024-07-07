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
	
	private static class Coord {
		public int row;
		public int col;
		public int dist;
		
		private Coord(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	private static int [][] bfs(int srcRow, int srcCol) {
		int [][] res = new int [n][m];
		Queue<Coord> q = new LinkedList<>();
		boolean [][] isVisited = new boolean [n][m];
		
		for(int [] row : res) Arrays.fill(row, -1);
		isVisited[srcRow][srcCol] = true;
		res[srcRow][srcCol] = 0;
		q.offer(new Coord(srcRow, srcCol, 0));
		
		while(!q.isEmpty()) {
			Coord coord = q.poll();
			int nextDist = coord.dist + 1;
			
			for(int [] d : DIR) {
				int nextRow = coord.row + d[0];
				int nextCol = coord.col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m
						|| isVisited[nextRow][nextCol] || map[nextRow][nextCol] == 0) continue;
				
				isVisited[nextRow][nextCol] = true;
				res[nextRow][nextCol] = nextDist;
				q.offer(new Coord(nextRow, nextCol, nextDist));
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) res[i][j] = 0;
			}
		}
		
		return res;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int srcRow = -1, srcCol = -1;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				int land = Integer.parseInt(st.nextToken());
				
				map[i][j] = land;
				if(land == 2) {
					srcRow = i;
					srcCol = j;
				}
			}
		}
		
		int [][] res = bfs(srcRow, srcCol);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) result.append(res[i][j]).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}