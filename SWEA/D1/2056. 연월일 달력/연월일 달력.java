import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int [] days = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static String makeDate(String date) {
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		
		if(month < 1 || month > 12 || day < 1 || day > days[month]) return "-1";
		
		StringBuilder res = new StringBuilder();
		
		return res.append(date.substring(0, 4)).append('/').append(date.substring(4, 6))
				.append('/').append(date.substring(6, 8)).toString();
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			String date = br.readLine();
			
			result.append('#').append(tc).append(' ').append(makeDate(date)).append('\n');
		}
		
		System.out.print(result);
	}
}