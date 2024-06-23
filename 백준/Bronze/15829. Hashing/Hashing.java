import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int R = 31;
	private static final int M = 1234567891;
	
	private static long hashCode(String word, int L) {
		long sum = 0;
		
		for(int i = 0; i < L; i++) {
			long a = word.charAt(i) - 'a' + 1;
															// (a*b) % M == (a % M * b % M) % M
			for(int j = 1; j <= i; j++) a = a % M * R % M;	// j = 0 일 때, 26^0 = 1이므로 포함 x
			sum += a;
		}
		
		return sum % M;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String word = br.readLine();
		
		System.out.println(hashCode(word, L));
	}
}