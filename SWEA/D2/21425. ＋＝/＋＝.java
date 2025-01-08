import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int minOperation(int A, int B, int N) {
		int cnt = 0;
		
		while(N >= A && N >= B) {
			if(A <= B) A += B;
			else B += A;
			cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()),
					N = Integer.parseInt(st.nextToken());
			
			result.append(minOperation(A, B, N)).append('\n');
		}
		
		System.out.print(result);
	}
}