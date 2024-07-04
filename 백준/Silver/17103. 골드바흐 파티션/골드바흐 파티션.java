import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 1000000;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean [] isNotPrime = new boolean [MAX + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(MAX); i++) {
			if(isNotPrime[i]) continue;
			
			for(int j = i * i; j <= MAX; j += i) isNotPrime[j] = true;
		}
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			for(int i = 2; i <= n / 2; i++) {
				if(!isNotPrime[i] && !isNotPrime[n - i]) cnt++;
			}
			
			result.append(cnt).append('\n');
		}
		
		System.out.print(result);
	}
}