import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			
			result.append('#').append(tc).append(' ')
				.append(N % 2 == 0 ? N / 2 * -1 : N / 2 + 1).append('\n');
		}
		
		System.out.print(result);
	}
}