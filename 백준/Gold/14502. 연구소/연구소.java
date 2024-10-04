import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static final int MAX_WALL = 3;
	private static int N;
	private static int M;
	private static int[][] lab;
	private static Queue<Area> viruses;
	
	private static class Area {
		private int row;
		private int col;
		
		private Area(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private static int virusSpread() {
		int safeArea = 0;
		int[][] copyOfLab = new int[N][M];
		Queue<Area> copyOfViruses = new LinkedList<>(viruses);
		
		for(int i = 0; i < N; i++) copyOfLab[i] = Arrays.copyOf(lab[i], M);
	
		while(!copyOfViruses.isEmpty()) {
			Area area = copyOfViruses.poll();
			
			for(int[] d : DIR) {
				int nextRow = area.row + d[0];
				int nextCol = area.col + d[1];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M
						|| copyOfLab[nextRow][nextCol] != 0) continue;

				copyOfLab[nextRow][nextCol] = 2;
				copyOfViruses.offer(new Area(nextRow, nextCol));
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyOfLab[i][j] == 0) safeArea++;
			}
		}
		
		return safeArea;
	}
	
	private static int dfs(int srcRow, int srcCol, int depth) {
		int max = Integer.MIN_VALUE;
		
		if(depth == MAX_WALL) return virusSpread();
		
		for(int i = srcRow; i < N; i++) {
			
			if(i > srcRow) srcCol = 0;
			for(int j = srcCol; j < M; j++) {
				if(lab[i][j] != 0) continue;
				
				lab[i][j] = 1;
				max = Math.max(dfs(i, j + 1, depth + 1), max);
				lab[i][j] = 0;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		viruses = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) viruses.offer(new Area(i, j));
			}
		}
		
		System.out.print(dfs(0, 0, 0));
	}
}