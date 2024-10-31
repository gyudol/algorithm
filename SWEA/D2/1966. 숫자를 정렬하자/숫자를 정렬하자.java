import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] seq = new int[N];
			
			for(int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(seq);
			
			result.append('#').append(tc);
			for(int num : seq) result.append(' ').append(num);
			result.append('\n');
		}
		
		System.out.print(result);
	}
}