import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int LEN = 2;
	private static final int MOD = 1000000007;
	private static final long[][] UNIT_MATRIX = {{1, 0}, {0, 1}};
	private static final long[][] INITIAL_MATRIX = {{1, 1}, {1, 0}};
	
	private static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] res = new long[LEN][LEN];
		
		res[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
		res[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
		res[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
		res[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;
		
		return res;
	}
	
	private static long[][] pow(long[][] a, long exp) {
		if(exp == 0) return UNIT_MATRIX;
		if(exp == 1) return INITIAL_MATRIX;
		
		long[][] res = pow(a, exp / 2);
		res = multiply(res, res);
		
		if(exp % 2 == 1) res = multiply(res, INITIAL_MATRIX);
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		 /*               n
		 *       | 1   1 |    | Fib(n+1)  Fib(n) |
		 * A^n = |       |  = |                  |
		 *       | 1   0 |    | Fib(n)  Fib(n-1) |   */
		
		System.out.print(pow(INITIAL_MATRIX, n - 1)[0][0]);
	}
}