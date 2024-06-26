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
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < LEN; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num % 2 == 1) sum += num;
			}
			
			result.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		
		System.out.print(result);
	}
}