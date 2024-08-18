import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] seq1 = br.readLine().toCharArray();
		char [] seq2 = br.readLine().toCharArray();
		int [][] dp = new int [seq1.length + 1][seq2.length + 1];
		
		for(int i = 1; i <= seq1.length; i++) {	// 공집합이 있으므로 1부터
			for(int j = 1; j <= seq2.length; j++) {
				if(seq1[i - 1] == seq2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.print(dp[seq1.length][seq2.length]);
	}
}