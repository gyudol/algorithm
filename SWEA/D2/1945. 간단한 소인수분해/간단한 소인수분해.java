import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int[] BASE = {2, 3, 5, 7, 11};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] exp = new int[BASE.length];
			
			for(int idx = 0; idx < BASE.length; idx++) {
				while(N % BASE[idx] == 0) {
					N /= BASE[idx];
					exp[idx]++;
				}
			}
			
			result.append('#').append(tc).append(' ');
			for(int num : exp) result.append(num).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}