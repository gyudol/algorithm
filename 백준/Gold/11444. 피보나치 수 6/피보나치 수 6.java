import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int LEN = 2;
	private static final int MOD = 1000000007;
	private static final long [][] initialMatrix = {{1, 1}, {1, 0}};
	
	private static long [][] multiply(long [][] o1, long [][] o2) {
		long [][] res = new long [LEN][LEN];
		
		res[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
		res[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
		res[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
		res[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;
		
		return res;
	}
	
	private static long [][] pow(long [][] a, long exp) {
		if(exp == 1 || exp == 0) return a;
		
		long [][] res = pow(a, exp / 2);
		res = multiply(res, res);
		
		if(exp % 2 == 1L) res = multiply(res, initialMatrix);
		
		return res;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long [][] a = new long [LEN][LEN];
		
		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		
		for(int i = 0; i < LEN; i++) a[i] = initialMatrix[i];
		
		// F_n 을 구하려면  A행렬을 n-1제곱 한 뒤 반환된 행렬 A11 원소를 출력하면 된다.
		System.out.print(pow(a, n - 1)[0][0]);
	}
}