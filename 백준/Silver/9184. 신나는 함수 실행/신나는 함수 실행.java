import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 100;
	private static final int STD = 50;
	private static int [][][] dp;
	
	private static int w(int a, int b, int c) {
		if(dp[a][b][c] != 0) return dp[a][b][c];
		if(a <= STD || b <= STD || c <= STD) return dp[a][b][c] = 1;
		if(a > 20 + STD || b > 20 + STD || c > 20 + STD) 
			return dp[a][b][c] = w(20 + STD, 20 + STD, 20 + STD);
		if(a < b && b < c) return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);	
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		dp = new int [MAX + 1][MAX + 1][MAX + 1];
		
		for(int i = 0; i <= MAX; i++) {
			for(int j = 0; j <= MAX; j++) {
				for(int k = 0; k <= MAX; k++) w(i, j, k);
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
					c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c== -1) break;
			
			result.append('w').append('(').append(a).append(',').append(' ').append(b)
				.append(',').append(' ').append(c).append(')').append(' ').append('=')
				.append(' ').append(w(a + STD, b + STD, c + STD)).append('\n');
		}
		
		System.out.print(result);
	}
}