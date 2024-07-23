import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	private static int n;
	private static int m;
	private static int [][] paper;
	private static boolean [][] isVisited;
	
	private static int dfs(int row, int col, int sum, int cnt) {
		if(cnt == 4) return sum;
		int max = Integer.MIN_VALUE;
		
		for(int [] d : DIR) {
			int nextRow = row + d[0];
			int nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || isVisited[nextRow][nextCol]) continue;
			
			if(cnt == 2) {	// ㅗ 모양 테트로미노 위해 추가 탐색
				isVisited[nextRow][nextCol] = true;
				max = Math.max(max, dfs(row, col, sum + paper[nextRow][nextCol], cnt + 1));	// 값은 더해주지만 row, col은 그대로
				isVisited[nextRow][nextCol] = false;
			}
			
			isVisited[nextRow][nextCol] = true;
			max = Math.max(max, dfs(nextRow, nextCol, sum + paper[nextRow][nextCol], cnt + 1));
			isVisited[nextRow][nextCol] = false;
		}
		
		return max;
	}
	
	private static int tetromino() {
		int max = Integer.MIN_VALUE;
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < m; col++) {
				isVisited[row][col] = true;
				max = Math.max(max, dfs(row, col, paper[row][col], 1));
				isVisited[row][col] = false;
			}
		}
		
		return max;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		paper = new int [n][m];
		isVisited = new boolean [n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(tetromino());	
	}
}