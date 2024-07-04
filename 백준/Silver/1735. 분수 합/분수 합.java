import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 2;
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int [][] fraction = new int [LEN][LEN];

		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < LEN; j++) fraction[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int [] res = {fraction[0][0] * fraction[1][1] + fraction[1][0] * fraction[0][1],
				fraction[0][1] * fraction[1][1]};
		int divGcd = gcd(res[0], res[1]);
		
		result.append(res[0] / divGcd).append(' ').append(res[1] / divGcd);
		
		System.out.print(result);
	}
}