import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int max(int [] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int num : arr) {
			if(num > max) max = num;
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] seq = new int [n];
		int [] dp = new int [n];
		
		Arrays.fill(dp, 1);
		for(int i = 0; i < n; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(seq[i] > seq[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		System.out.print(max(dp));
	}
}