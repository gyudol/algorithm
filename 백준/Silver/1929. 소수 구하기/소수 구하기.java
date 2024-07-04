import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		boolean [] isNotPrime = new boolean [n + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(isNotPrime[i]) continue;
			
			for(int j = i * i; j <= n; j += i) isNotPrime[j] = true;
		}
		
		for(int i = m; i <= n; i++) {
			if(!isNotPrime[i]) result.append(i).append('\n');
		}
		
		System.out.print(result);
	}
}
