import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class Counseling {
		private int time;
		private int revenue;
		
		private Counseling(int time, int revenue) {
			this.time = time;
			this.revenue = revenue;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		Counseling[] counseling = new Counseling[N];
		int[] dp = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			counseling[i] = new Counseling(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			int nextDay = i + counseling[i].time;
			
			if(nextDay <= N) dp[nextDay] = Math.max(dp[nextDay], dp[i] + counseling[i].revenue);
			
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.print(dp[N]);
	}
}