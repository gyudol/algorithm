import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		boolean[] isNotPrime = new boolean[N + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isNotPrime[i]) continue;
			
			for (int j = i * i; j <= N; j += i) isNotPrime[j] = true;
		}
		
		for (int num = M; num <= N; num++) {
			if (!isNotPrime[num]) result.append(num).append('\n');
		}
		
		System.out.print(result);
	}
}