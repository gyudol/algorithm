import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int N = 5;
	private static final int TARGET = 3;
	
	private static boolean checkBingo(int[][] board) {
		int bingo = 0, downDiag = 0, upDiag = 0;
		
		for(int i = 0; i < N; i++) {
			int row = 0, col = 0;
			
			for(int j = 0; j < N; j++) {
				row += board[i][j];
				col += board[j][i];
				
				if(i == j) downDiag += board[i][i];
				if(i + j == N - 1) upDiag += board[i][j];
			}
			
			if(row == 0) bingo++;
			if(col == 0) bingo++;
		}
		
		if(downDiag == 0) bingo++;
		if(upDiag == 0) bingo++;
		
		return bingo >= TARGET;
	}
	
	private static boolean playBingo(int[][] board, int num) {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] == num) {
					board[row][col] = 0;
					return checkBingo(board);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[N][N];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) 
				board[row][col] = Integer.parseInt(st.nextToken());
		}
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) {
				if(playBingo(board, Integer.parseInt(st.nextToken()))) {
					System.out.print(row * N + col + 1);
					return;
				}
			}
		}
	}
}