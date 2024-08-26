import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MIN = -100000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[n + 1];
		int max = MIN;
		
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			dp[i] = Math.max(num + dp[i - 1], num);
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}