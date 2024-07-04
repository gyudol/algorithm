import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 2;
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int [][] fraction = new int [LEN][LEN];

		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < LEN; j++) fraction[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int lcmOfDen = lcm(fraction[0][1], fraction[1][1]);
		int numerator = lcmOfDen / fraction[0][1] * fraction[0][0] + lcmOfDen / fraction[1][1] * fraction[1][0];
		int gcdOfFrac = gcd(numerator, lcmOfDen);
		
		result.append(numerator / gcdOfFrac).append(' ').append(lcmOfDen / gcdOfFrac);
		
		System.out.print(result);
	}
}