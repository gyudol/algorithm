import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int a;
	private static int c;
	
	private static long mul(int exp) {	// divide and conquer
		if(exp == 1) return a % c;
		
		long sum = mul(exp / 2) % c;
		
		if(exp % 2 == 0) return (sum * sum) % c;
		else return (((sum * sum) % c) * (a % c)) % c;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.print(mul(b));
	}
}