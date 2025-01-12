import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int[][] STRAIGHT_DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
	private static final int[][] DIAGONAL_DIR = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
	private static int count(int N, int M, int r, int c, int[][] flies, int[][] dir) {
		int sum = flies[r][c];
		
		for(int[] d : dir) {
			int curRow = r, curCol = c;
			
			for(int i = 0; i < M - 1; i++) {
				curRow += d[0];
				curCol += d[1];
				
				if(curRow < 0 || curRow >= N || curCol < 0 || curCol >= N) break;
				
				sum += flies[curRow][curCol];
			}
		}
		
		return sum;
	}
	
	private static int getMaxKill(int N, int M, int[][] flies) {
		int max = Integer.MIN_VALUE;
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) 
				max = Math.max(Math.max(max, count(N, M, row, col, flies, STRAIGHT_DIR)), 
						count(N, M, row, col, flies, DIAGONAL_DIR));
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder result = new StringBuilder();
		 final int T = Integer.parseInt(br.readLine());
		 
		 for(int tc = 1; tc <= T; tc++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			 final int[][] flies = new int[N][N];
			 
			 for(int row = 0; row < N; row++) {
				 st = new StringTokenizer(br.readLine());
				 for(int col = 0; col < N; col++) {
					 flies[row][col] = Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 result.append('#').append(tc).append(' ').append(getMaxKill(N, M, flies)).append('\n');
		 }
		 
		 System.out.print(result);
	}
}