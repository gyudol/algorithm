import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			int[][] pascal = new int[N + 1][N + 1];
			
			result.append('#').append(tc).append('\n');
			result.append(pascal[1][1] = 1).append('\n');
			
			for(int row = 2; row <= N; row++) {
				for(int col = 1; col <= N; col++) {
					pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
					
					if(pascal[row][col] == 0) break;
					result.append(pascal[row][col]).append(' ');
				}
				
				result.append('\n');
			}
		}
		
		System.out.print(result);
	}
}