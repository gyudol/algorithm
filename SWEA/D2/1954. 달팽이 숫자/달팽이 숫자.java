import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			int row = 0, col = 0, rot = 0, num = 0;
			int[][] snail = new int[N][N];
			
			while(++num < N * N) {
				snail[row][col] = num;
				
				while(row + DIR[rot][0] < 0 || row + DIR[rot][0] >= N || col + DIR[rot][1] < 0 ||
						col + DIR[rot][1] >= N || snail[row + DIR[rot][0]][col + DIR[rot][1]] != 0) rot = (rot + 1) % DIR.length;
				
				row += DIR[rot][0];
				col += DIR[rot][1];
			}
			
			snail[row][col] = num;
			
			result.append('#').append(tc).append('\n');
			for(int[] line : snail) {
				for(int n : line) result.append(n).append(' ');
				result.append('\n');
			}
		}
		
		System.out.print(result);
	}
}