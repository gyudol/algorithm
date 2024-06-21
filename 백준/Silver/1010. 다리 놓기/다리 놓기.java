import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int dp [][] = new int [30][30];
	
	private static int combination(int a, int b) {
		if(b == 0 || a == b) return dp[a][b] = 1;
		if(dp[a][b] != 0) return dp[a][b];
		
		return dp[a][b] = combination(a - 1, b - 1) + combination(a - 1, b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			result.append(combination(M, N)).append('\n');
		}
		
		System.out.print(result);
	}
}