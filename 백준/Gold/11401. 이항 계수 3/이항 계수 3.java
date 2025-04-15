import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static final int P = 1_000_000_007;
	
	static long power(long x, long y) {
		long res = 1L;
		x %= P;
		
		while (y > 0) {
			if (y % 2 == 1) res = res * x % P;
			y >>= 1;
			x = x * x % P;
		}
		
		return res;
	}
	
	static long nCr(int N, int K) {
		if (K == 0) return 1L;
		
		long[] fac = new long[N + 1];
		fac[0] = fac[1] = 1;
		
		for (int i = 2; i <= N; i++) fac[i] = fac[i - 1] * i % P;
		
		return (fac[N] * power(fac[K], P - 2) % P)
				* (power(fac[N - K], P - 2) % P) % P;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		System.out.print(nCr(N, K));
	}
}