import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static final int LEN = 10;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numbers = new int[LEN];
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			int total = 0, cnt = 0;
			
			for(int i = 0; i < LEN; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				min = Math.min(numbers[i], min);
				max = Math.max(numbers[i], max);
			}
			
			for(int number : numbers) {
				if(number != min && number != max) {
					total += number;
					cnt++;
				}
			}
			
			result.append('#').append(tc).append(' ').append(Math.round(total * 1.0 / cnt)).append('\n');
		}
		
		System.out.print(result);
	}
}