import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static boolean isPalindrome(String word) {
		return new StringBuilder(word).reverse().toString().equals(word);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			result.append('#').append(tc).append(' ')
				.append(isPalindrome(br.readLine()) ? 1 : 0).append('\n');
		}
		
		System.out.print(result);
	}
}