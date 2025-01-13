import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int dfs(int sum, int src, int N, int B, int[] heights) {
		if(sum >= B) return sum;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = src; i < N; i++) min = Math.min(min, dfs(sum + heights[i], i + 1, N, B, heights));
		
		return min;
	}
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder result = new StringBuilder();
		 final int T = Integer.parseInt(br.readLine());
		 
		 for(int tc = 1; tc <= T; tc++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 final int N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			 int[] heights = new int[N];
			 
			 st = new StringTokenizer(br.readLine());
			 for(int i = 0; i < N; i++) heights[i] = Integer.parseInt(st.nextToken());
			 
			 Arrays.sort(heights);
			 result.append('#').append(tc).append(' ').append(dfs(0, 0, N, B, heights) - B).append('\n');
		 }
		 
		 System.out.print(result);
	}
}