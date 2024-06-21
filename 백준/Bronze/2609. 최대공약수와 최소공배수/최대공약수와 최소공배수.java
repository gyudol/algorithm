import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		
		int gcd = gcd(a, b), lcm = a * b / gcd;
		
		result.append(gcd).append('\n').append(lcm);
		
		System.out.print(result);
	}
}