import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int N;
	private static int[][] region;
	private static boolean[][] isVisited;
	
	private static int dfs(int row, int col, int height) {
		if(isVisited[row][col] || region[row][col] <= height) return 0;
		isVisited[row][col] = true;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
			dfs(nextRow, nextCol, height);
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		region = new int[N][N];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				region[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, region[i][j]);
				max = Math.max(max, region[i][j]);
			}
		}
		
		for(int height = min - 1; height < max; height++) {
			isVisited = new boolean[N][N];
			int cnt = 0;
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) cnt += dfs(row, col, height);
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.print(result);
	}
}