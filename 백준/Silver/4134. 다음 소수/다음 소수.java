import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean isPrime(long n) {
		if(n <= 1) return false;
		
		for(long i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			long n = Long.parseLong(br.readLine());
			
			while(!isPrime(n)) n++;
			
			result.append(n).append('\n');
		}
		
		System.out.print(result);
	}
}