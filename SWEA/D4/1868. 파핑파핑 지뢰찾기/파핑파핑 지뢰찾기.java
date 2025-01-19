import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int[][] DIR = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, 
			{1, -1}, {0, -1}, {-1, -1}};
	
	private static int countMines(int row, int col, int N, char[][] board) {
		int mines = 0;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
					&& board[nextRow][nextCol] == '*') mines++;
		}
		
		return mines;
	}
	
	private static void dfs(int row, int col, int N, char[][] board, boolean[][] isVisited) {
		if(isVisited[row][col]) return;
		isVisited[row][col] = true;
		
		if(countMines(row, col, N, board) > 0) return;
		
		for(int[] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
					&& board[nextRow][nextCol] == '.') dfs(nextRow, nextCol, N, board, isVisited);
		}
	}
	
	private static int mineSweeper(int N, char[][] board) {
		int clickCnt = 0;
		boolean[][] isVisited = new boolean[N][N];
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(board[row][col] == '*') isVisited[row][col] = true;
				
				if(!isVisited[row][col] && countMines(row, col, N, board) == 0) {
					dfs(row, col, N, board, isVisited);
					clickCnt++;
				}
			}
		}
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(!isVisited[row][col]) clickCnt++;
			}
		}
		
		return clickCnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			
			for(int row = 0; row < N; row++) board[row] = br.readLine().toCharArray();
			
			result.append('#').append(tc).append(' ').append(mineSweeper(N, board)).append('\n');
		}
		
		System.out.print(result);
	}
}