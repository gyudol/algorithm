import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int LEN = 10;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			
			for(int i = 0; i < LEN; i++) sum += Integer.parseInt(st.nextToken());
			
			result.append('#').append(tc).append(' ').append(Math.round(sum * 1.0 / LEN)).append('\n');
		}
		
		System.out.print(result);
	}
}