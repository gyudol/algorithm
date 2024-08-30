import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, 1}, {-1, 1}, {1, 0}, {1, 1}, {0, -1}, {1, -1}, {-1, 0}, {-1, -1}};
	
	private static int dfs(int row, int col, int[][] islands, boolean[][] isVisited) {
		if(isVisited[row][col] || islands[row][col] == 0) return 0;
		isVisited[row][col] = true;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= islands.length || nextCol < 0 || nextCol >= islands[nextRow].length) continue;
			
			dfs(nextRow, nextCol, islands, isVisited);
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
			
			if(w == 0) break;
			
			int cnt = 0;
			int[][] islands = new int[h][w];
			boolean[][] isVisited = new boolean [h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < w; j++) islands[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int row = 0; row < h; row++) {
				for(int col = 0; col < w; col++) cnt += dfs(row, col, islands, isVisited);
			}
			
			result.append(cnt).append('\n');
		}
		
		System.out.print(result);
	}
}