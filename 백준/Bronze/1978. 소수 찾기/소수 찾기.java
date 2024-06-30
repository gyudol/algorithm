import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(isPrime(Integer.parseInt(st.nextToken()))) cnt++;
		}
		
		System.out.print(cnt);
	}
}