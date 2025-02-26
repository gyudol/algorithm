import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	
	static int getRevenue(int[][] plants) {
		int sum = 0, mid = N / 2, offset = 0;
		
		for(int row = 0; row < N; row++) {
			for(int col = mid - offset; col <= mid + offset; col++) 
				sum += plants[row][col];
			
			if(row < N / 2) offset++;
			else offset--;
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] plants = new int[N][N];
			
			for(int row = 0; row < N; row++) plants[row] = Arrays.stream(br.readLine().split(""))
					.mapToInt(Integer::parseInt).toArray();
			
			result.append('#').append(tc).append(' ').append(getRevenue(plants)).append('\n');
		}
	
		System.out.print(result);
	}
}