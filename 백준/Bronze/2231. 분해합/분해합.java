import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int decompSum(int n) {
		int sum = n;
		
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
	}
	
	private static int constructor(int n) {
		for(int i = 1; i <= n; i++) {
			if(decompSum(i) == n) return i;
		}
		
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		System.out.print(constructor(n));
	}
}