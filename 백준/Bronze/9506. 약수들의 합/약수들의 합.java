import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static String isPerfect(int n) {
		List<Integer> divisors = new ArrayList<>();
		int sum = 0;
		
		for(int i = 1; i <= n / 2; i++) {
			if(n % i == 0) {
				divisors.add(i);
				sum += i;
				
				if(sum > n) return "is NOT perfect.";
			}
		}
		
		if(sum == n) {
			StringBuilder result = new StringBuilder().append('=').append(' ');
		
			for(int divisor : divisors) result.append(divisor).append(' ').append('+').append(' ');
			result.setLength(result.length() - 3);
			
			return result.toString();
		}
		
		return "is NOT perfect.";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == -1) break;
			
			result.append(n).append(' ').append(isPerfect(n)).append('\n');
		}
		
		System.out.print(result);
	}
}