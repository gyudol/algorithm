import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 123456 * 2;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		boolean [] isNotPrime = new boolean [MAX + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(MAX); i++) {
			if(isNotPrime[i]) continue;
			
			for(int j = i * i; j <= MAX; j += i) isNotPrime[j] = true;
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			if(n == 0) break;
			
			for(int i = n + 1; i <= n * 2; i++) {
				if(!isNotPrime[i]) cnt++;
			}
			
			result.append(cnt).append('\n');
		}
		
		System.out.print(result);
	}
}
