import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final int MOD = 3;
	
	private static String game369(int num) {
		int clap = 0;
		
		for(char c : Integer.toString(num).toCharArray()) {
			if(c != '0' && c % MOD == 0) clap++;
		}
		
		if(clap == 0) return Integer.toString(num);
		
		String action = "";
		for(int i = 0; i < clap; i++) action += "-";
        
		return action;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		
		for(int num = 1; num <= N; num++) {
			result.append(game369(num)).append(' ');
		}
		
		System.out.print(result);
	}
}