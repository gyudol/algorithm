import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
		
		System.out.print(lcm(a, b));
	}
}