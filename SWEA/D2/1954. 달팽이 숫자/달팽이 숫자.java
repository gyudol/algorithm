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
			int row = 0, col = 0, sign = 0, num = 0;
			int[][] snail = new int[N][N];
			
			while(++num <= N * N) {
				snail[row][col] = num;
                
                int nextRow = row + DIR[sign][0], nextCol = col + DIR[sign][1];
				
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N 
                      || snail[nextRow][nextCol] != 0) {
                    sign = (sign + 1) % DIR.length;
                    nextRow = row + DIR[sign][0];	nextCol = col + DIR[sign][1];
                }
				
				row = nextRow;	col = nextCol;
			}
			
			result.append('#').append(tc).append('\n');
			for(int[] line : snail) {
				for(int n : line) result.append(n).append(' ');
				result.append('\n');
			}
		}
		
		System.out.print(result);
	}
}