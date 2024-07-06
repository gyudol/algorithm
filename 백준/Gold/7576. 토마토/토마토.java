import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static int m;
	private static int [][] tomatoes;
	private static boolean [][] isVisited;
	private static Queue<Tomato> ripeTomatoes;
	
	private static class Tomato {
		public int row;
		public int col;
		public int day;
		
		private Tomato(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}
	}
	
	private static int bfs(int raw) {
		if(raw == 0) return 0;
		
		while(!ripeTomatoes.isEmpty()) {
			Tomato tomato = ripeTomatoes.poll();
			int nextDay = tomato.day + 1;
			
			for(int [] d : DIR) {
				int nextRow = tomato.row + d[0];
				int nextCol = tomato.col + d[1];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || 
						tomatoes[nextRow][nextCol] == -1 || isVisited[nextRow][nextCol]) continue;

				if(--raw == 0) return nextDay;
				isVisited[nextRow][nextCol] = true;
				ripeTomatoes.offer(new Tomato(nextRow, nextCol, nextDay));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
		int raw = 0;
		tomatoes = new int [n][m];
		isVisited = new boolean [n][m];
		ripeTomatoes = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				tomatoes[i][j] = Integer.parseInt(st.nextToken());

				if(tomatoes[i][j] == 1) {
					isVisited[i][j] = true;
					ripeTomatoes.offer(new Tomato(i, j, 0));
				}
				else if(tomatoes[i][j] == 0) raw++;
			}
		}
		
		System.out.print(bfs(raw));
	}
}