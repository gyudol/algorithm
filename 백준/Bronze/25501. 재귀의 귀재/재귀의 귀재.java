import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int callCnt;
	
	private static int recursion(String str, int l, int r) {
		callCnt++;
		if(l >= r) return 1;
		else if(str.charAt(l) != str.charAt(r)) return 0;
		else return recursion(str, l+1, r-1);
	}
	
	private static int isPalindrome(String str) {
		return recursion(str, 0, str.length() - 1);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			callCnt = 0;
			
			result.append(isPalindrome(str)).append(' ').append(callCnt).append('\n');
		}
		
		System.out.print(result);
	}
}