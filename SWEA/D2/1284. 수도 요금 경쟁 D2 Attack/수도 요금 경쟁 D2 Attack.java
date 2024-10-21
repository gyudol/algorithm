import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int P = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken()),
					R = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()),
					W = Integer.parseInt(st.nextToken());
			
			int A = P * W;
			int B = W <= R ? Q : Q + (W - R) * S;
			
			result.append('#').append(tc).append(' ').append(A <= B ? A : B).append('\n');
		}
		
		System.out.print(result);
	}
}