import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = 
		{{0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};
	private static int [][][] tomatoes;
	private static Queue<Tomato> ripeTomatoes;
	private static int N, M, H;
	
	private static class Tomato {
		public int row;
		public int col;
		public int height;
		public int day;
		
		private Tomato(int row, int col, int height, int day) {
			this.row = row;
			this.col = col;
			this.height = height;
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
				int nextHeight = tomato.height + d[2];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M || nextHeight < 0 
						|| nextHeight >= H || tomatoes[nextRow][nextCol][nextHeight] != 0) continue;
				
				if(--raw == 0) return nextDay;
				tomatoes[nextRow][nextCol][nextHeight] = 1;
				ripeTomatoes.offer(new Tomato(nextRow, nextCol, nextHeight, nextDay));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int raw = 0;
		tomatoes = new int [N][M][H];
		ripeTomatoes = new LinkedList<>();
		
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				for(int m = 0; m < M; m++) {
					tomatoes[n][m][h] = Integer.parseInt(st.nextToken());
					
					if(tomatoes[n][m][h] == 1) ripeTomatoes.offer(new Tomato(n, m, h, 0));
					else if(tomatoes[n][m][h] == 0) raw++;
				}
			}
		}
		
		System.out.print(bfs(raw));
	}
}