import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int divisor(int n) {
		for(int i = 2; i <= n; i++) {
			if(n % i == 0) return i;
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		while(n > 1) {
			int divisor = divisor(n);
			
			result.append(divisor).append('\n');
			n /= divisor;
		}
		
		System.out.print(result);
	}
}