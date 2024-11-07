import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int MAX_HOUR = 12;
	private static final int MAX_MINUTE = 60;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hour = Integer.parseInt(st.nextToken());
			int minute = Integer.parseInt(st.nextToken());
			
			hour += Integer.parseInt(st.nextToken());
			minute += Integer.parseInt(st.nextToken());
			
			hour = ((hour + minute / MAX_MINUTE) - 1) % MAX_HOUR + 1;
			minute %= MAX_MINUTE;
			
			result.append('#').append(tc).append(' ').append(hour).append(' ').append(minute).append('\n');
		}
		
		System.out.print(result);
	}
}