import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean isPrime(int num) {
		if(num <= 1) return false;
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int m = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine());
		int sum = 0, minPrime = -1;
		
		for(int i = m; i <= n; i++) {
			if(isPrime(i)) {
				sum += i;
				if(minPrime == -1) minPrime = i;
			}
		}
		
		if(sum != 0) result.append(sum).append('\n');
		result.append(minPrime);
		
		System.out.print(result);
	}
}