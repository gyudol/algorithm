import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static final int MAX_COL = 3;
	private static int[][][] board;
	
	private static int prevMinNumber(int row, int col) {
		if(row == 0) return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = -1; i <= 1; i++) {
			if(col + i < 0 || col + i >= MAX_COL) continue;
			
			min = Math.min(min, board[0][row - 1][col + i]);
		}
		
		return min;
	}
	
	private static int prevMaxNumber(int row, int col) {
		if(row == 0) return 0;
		
		int max = Integer.MIN_VALUE;
		
		for(int i = -1; i <= 1; i++) {
			if(col + i < 0 || col + i >= MAX_COL) continue;
			
			max = Math.max(max, board[1][row - 1][col + i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		board = new int [2][N][MAX_COL];
	
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < MAX_COL; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				board[0][i][j] = num + prevMinNumber(i, j);
				board[1][i][j] = num + prevMaxNumber(i, j);
			}
		}
		
		for(int num : board[0][N - 1]) min = Math.min(min, num);
		for(int num : board[1][N - 1]) max = Math.max(max, num);
		
		result.append(max).append(' ').append(min);
		System.out.print(result);
	}
}