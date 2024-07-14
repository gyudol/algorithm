import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int cntFib(int n) {
		int cnt = 0;
		if(n == 1 || n == 2) return 1;
		
		return cnt += cntFib(n - 1) + cntFib(n - 2);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());	// 5 <= n <= 40
		
		result.append(cntFib(n)).append(' ').append(n - 2);
		
		System.out.print(result);
	}
}