import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			result.append(lcm(a, b)).append('\n');
		}
		
		System.out.print(result);
	}
}