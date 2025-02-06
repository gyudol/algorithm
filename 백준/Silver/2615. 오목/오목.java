import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int N = 19;
	private static final int WINNING_COUNT = 5;
	private static final int[][] DIRECTIONS = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	private static StringBuilder result = new StringBuilder();
	
	private static boolean isPromising(int[][] board, int row, int col, int[] d) {
		int prevRow = row - d[0], prevCol = col - d[1];
		
		if(prevRow >= 0 && prevRow < N && prevCol >= 0 
				&& board[prevRow][prevCol] == board[row][col]) return false;

		int upcomingRow = row + d[0] * WINNING_COUNT, upcomingCol = col + d[1] * WINNING_COUNT;
		
		if(upcomingRow >= 0 && upcomingRow < N && upcomingCol < N 
				&& board[upcomingRow][upcomingCol] == board[row][col]) return false;
		
		return true;
	}
	
	private static boolean checkWinner(int[][] board, int row, int col) {
		int pos = board[row][col];
		
		C : for(int[] d : DIRECTIONS) {
			if(!isPromising(board, row, col, d)) continue;
			
			for(int offset = 1; offset < WINNING_COUNT; offset++) {
				int nextRow = row + d[0] * offset, nextCol = col + d[1] * offset;
				
				if(nextRow < 0 || nextRow >= N || nextCol >= N || board[nextRow][nextCol] != pos) continue C;
			}
			
			result.append(pos).append('\n').append(row + 1).append(' ').append(col + 1);
			return true;
		}
		
		return false;
	}
	
	private static void gomoku(int[][] board) {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] != 0 && checkWinner(board, row, col)) return;
			}
		}
		
		result.append('0');
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int[][] board = new int[N][N];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) board[row][col] = Integer.parseInt(st.nextToken());
		}
		
		gomoku(board);
		System.out.print(result);
	}
}