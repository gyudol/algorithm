import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static int m;
	
	private static class Room {
		public int row;
		public int col;
		public int brokenCnt;
		
		private Room(int row, int col, int brokenCnt) {
			this.row = row;
			this.col = col;
			this.brokenCnt = brokenCnt;
		}
	}
	
	private static int bfs(int [][] maze, boolean [][] isVisited) {
		PriorityQueue<Room> pq = new PriorityQueue<>((r1, r2) -> 
			Integer.compare(r1.brokenCnt, r2.brokenCnt));
		pq.offer(new Room(0, 0, 0));
		isVisited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Room r = pq.poll();
			
			if(r.row == n - 1 && r.col == m - 1) return r.brokenCnt;
			
			for(int [] d : DIR) {
				int nextRow = r.row + d[0], nextCol = r.col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m
						|| isVisited[nextRow][nextCol]) continue;
				int brokenCnt = r.brokenCnt + (maze[nextRow][nextCol] == 1 ? 1 : 0);
				
				isVisited[nextRow][nextCol] = true;
				pq.offer(new Room(nextRow, nextCol, brokenCnt));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
		int [][] maze = new int [n][m];
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < m; j++) maze[i][j] = line.charAt(j) - '0';
		}
		
		System.out.print(bfs(maze, new boolean [n][m]));
	}
}