import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int countBitFlips(String origin) {
		int cnt = 0;
		char prev = '0';
		
		for (char c : origin.toCharArray()) {
			if (c != prev) {
				prev = c;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			result.append('#').append(tc).append(' ')
				.append(countBitFlips(br.readLine())).append('\n');
		}
		
		System.out.print(result);
	}
}