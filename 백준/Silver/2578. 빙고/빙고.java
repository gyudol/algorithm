import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int N = 5;
	private static final int TARGET = 3;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static boolean isBingo(int[][] board) {
		int lineCnt = 0;
		
		for(int row = 0; row < N; row++) {
			int erasedCnt = 0;
			
			for(int col = 0; col < N; col++) {
				if(board[row][col] == 0) erasedCnt++;
			}
			
			if(erasedCnt == N) lineCnt++;
		}
		
		for(int col = 0; col < N; col++) {
			int erasedCnt = 0;
			
			for(int row = 0; row < N; row++) {
				if(board[row][col] == 0) erasedCnt++;
			}
			
			if(erasedCnt == N) lineCnt++;
		}
		
		int erasedCnt = 0;
		
		for(int row = 0, col = 0; row < N; row++, col++) {
			if(board[row][col] == 0) erasedCnt++;
		}
		
		if(erasedCnt == N) lineCnt++;
		
		erasedCnt = 0;
		
		for(int row = 4, col = 0; col < N; row--, col++) {
			if(board[row][col] == 0) erasedCnt++;
		}
		
		if(erasedCnt == N) lineCnt++;
		
		return lineCnt >= TARGET;
	}
	
	private static void erase(int[][] board, int number) {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] == number) {
					board[row][col] = 0;
					return;
				}
			}
		}
	}
	
	private static int playBingo(int[][] board, int[][] calling) {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				erase(board, calling[row][col]);
				if(isBingo(board)) return row * N + col + 1;
			}
		}
		
		return -1;
	}
	
	private static void initialize(int[][] array) throws IOException {
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int col = 0; col < N; col++) 
				array[row][col] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[][] board = new int[N][N], calling = new int[N][N];
		
		initialize(board);
		initialize(calling);
		
		System.out.print(playBingo(board, calling));
	}
}