import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int MAX_LENGTH = 10;
	
	private static boolean isPattern(String str, String sub) {
		int offset = sub.length();
		
		for(int src = offset; src < str.length() / offset * offset; src += offset) {
			if(!str.substring(src, src + offset).equals(sub)) return false;
		}
		
		return true;
	}
	
	private static int patternLength(String str) {
		for(int len = 1; len <= MAX_LENGTH; len++) {
			String sub = str.substring(0, len);
			
			if(isPattern(str, sub)) return len;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			result.append('#').append(tc).append(' ').append(patternLength(str)).append('\n');
		}
		
		System.out.print(result);
	}
}