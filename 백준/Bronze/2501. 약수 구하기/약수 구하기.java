import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int divisor(int n, int k) {
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0 && ++cnt == k) return i;
		}
		
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()) , k = Integer.parseInt(st.nextToken());
		
		System.out.print(divisor(n, k));
	}
}