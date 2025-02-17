import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private static void fillBomb(char[][] state) {
		for(int row = 0; row < state.length; row++) {
			for(int col = 0; col < state[row].length; col++) {
				if(state[row][col] == '\u0000') state[row][col] = 'O';
			}
		}
	}
	
	private static void explode(int R, int C, char[][] state, char[][] board) {
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				if(board[row][col] != 'O') continue;
				state[row][col] = '.';
				
				for(int[] d : DIR) {
					int nextRow = row + d[0], nextCol = col + d[1];
					
					if(nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
					state[nextRow][nextCol] = '.';
				}
			}
		}
		
		fillBomb(state);
	}
	
	private static char[][] bomberman(int N, int R, int C, char[][] board) {
		if(N == 1) return board;
		
		char[][] state = new char[R][C];
		
		if(N % 2 == 0) fillBomb(state);
		else {
			explode(R, C, state, board);	// N % 4 == 3
			
			if(N % 4 == 1) {
				for(int row = 0; row < R; row++) board[row] = Arrays.copyOf(state[row], C);
				state = new char[R][C];
				explode(R, C, state, board);
			}
		}
		
		return state;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()),
				N = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		
		for(int row = 0; row < R; row++) board[row] = br.readLine().toCharArray();
		board = bomberman(N, R, C, board);
		
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) result.append(board[row][col]);
			result.append('\n');
		}
		
		System.out.print(result);
	}
}