import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static int daysBetween(int monthA, int dayA, int monthB, int dayB) {
		int sum = 0;
		
		for(int month = monthA; month < monthB; month++) sum += DAYS[month];
		
		return sum + dayB - dayA + 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int monthA = Integer.parseInt(st.nextToken()), dayA = Integer.parseInt(st.nextToken()),
					monthB = Integer.parseInt(st.nextToken()), dayB = Integer.parseInt(st.nextToken());
			
			result.append('#').append(tc).append(' ').append(daysBetween(monthA, dayA, monthB, dayB)).append('\n');
		}
		
		System.out.print(result);
	}
}