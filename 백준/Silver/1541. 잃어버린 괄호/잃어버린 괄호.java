import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int [][][] dp;	// 0: min, 1: max
	
	private static int min(List<String> tokens, int src, int des) {	// [src, des)
		if(dp[src][des][0] != Integer.MAX_VALUE) return dp[src][des][0];
		if(des - src == 1) 
			return dp[src][des][0] = dp[src][des][1] = Integer.parseInt(tokens.get(src));
		int min = Integer.MAX_VALUE;
		
		for(int i = src; i < des; i++) {
			if(tokens.get(i).equals("-"))
				min = Math.min(min, min(tokens, src, i) - max(tokens, i + 1, des));
			else if(tokens.get(i).equals("+"))
				min = Math.min(min, min(tokens, src, i) + min(tokens, i + 1, des));
		}
		
		return dp[src][des][0] = min;
	}
	
	private static int max(List<String> tokens, int src, int des) {
		if(dp[src][des][1] != Integer.MIN_VALUE) return dp[src][des][1];
		if(des - src == 1) 
			return dp[src][des][0] = dp[src][des][1] = Integer.parseInt(tokens.get(src));
		int max = Integer.MIN_VALUE;
		
		for(int i = src; i < des; i++) {
			if(tokens.get(i).equals("-"))
				max = Math.max(max, max(tokens, src, i) - min(tokens, i + 1, des));
			else if(tokens.get(i).equals("+"))
				max = Math.max(max, max(tokens, src, i) + max(tokens, i + 1, des));
		}
		
		return dp[src][des][1] = max;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"+-", true);
		List<String> tokens = new ArrayList<>();
		
		while(st.hasMoreTokens()) tokens.add(st.nextToken());
		
		dp = new int [tokens.size()][tokens.size() + 1][2];
		
		for(int src = 0; src < tokens.size(); src++) {
			for(int des = 1; des < tokens.size() + 1; des++) {
				dp[src][des][0] = Integer.MAX_VALUE;
				dp[src][des][1] = Integer.MIN_VALUE;
			}
		}
			
		System.out.print(min(tokens, 0, tokens.size()));
	}
}