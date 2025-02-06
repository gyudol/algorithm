import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int N = 19;
	private static final int[][] DIR = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	private static boolean[][][] isVisited;
	private static StringBuilder result = new StringBuilder();
	
	private static boolean isPromising(int[][] board, int row, int col, int dIdx) {
		int pos = board[row][col], cnt = 0;
		
		while(row >= 0 && row < N && col < N && board[row][col] == pos && !isVisited[row][col][dIdx]) {
			isVisited[row][col][dIdx] = true;
			row += DIR[dIdx][0];	col += DIR[dIdx][1];
			cnt++;
		}
		
		if(cnt == 5) return true;
		return false;
	}
	
	private static void gomoku(int[][] board) {
		for(int col = 0; col < N; col++) {
			for(int row = 0; row < N; row++) {
				if(board[row][col] == 0) continue;
				
				for(int dIdx = 0; dIdx < DIR.length; dIdx++) {
					if(isPromising(board, row, col, dIdx)) {
						result.append(board[row][col]).append('\n').append(row + 1).append(' ').append(col + 1);
						return;
					}
				}
			}
		}
		
		result.append('0');
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int[][] board = new int[N][N];
		isVisited = new boolean[N][N][DIR.length];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) board[row][col] = Integer.parseInt(st.nextToken());
		}
		
		gomoku(board);
		System.out.print(result);
	}
}