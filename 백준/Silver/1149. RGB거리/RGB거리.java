import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int COLOR_TYPES = 3;
	private static int [][] costs;
	private static int [][] dp;
	
	private static void rgbDistance(int depth) {
		if(dp[depth][0] != Integer.MAX_VALUE) return;
		
		for(int color = 0; color < COLOR_TYPES; color++) {
			for(int prevColor = 0; prevColor < COLOR_TYPES; prevColor++) {
				if(prevColor == color) continue;
				
				dp[depth][color] = 
						Math.min(dp[depth][color], costs[depth][color] + dp[depth - 1][prevColor]);
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		costs = new int [n][COLOR_TYPES];
		dp = new int [n][COLOR_TYPES];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < COLOR_TYPES; j++) costs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int [] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
		dp[0] = Arrays.copyOf(costs[0], COLOR_TYPES);
		
		for(int depth = 1; depth < n; depth++) rgbDistance(depth);
		
		System.out.print(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
	}
}