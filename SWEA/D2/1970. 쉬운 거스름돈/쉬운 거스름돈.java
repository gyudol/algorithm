import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			result.append('#').append(tc).append('\n');
			for(int money : amount) {
				result.append(N / money).append(' ');
				N %= money;
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}