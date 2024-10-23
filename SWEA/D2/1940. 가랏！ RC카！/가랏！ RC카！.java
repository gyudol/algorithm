import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			int v = 0, s = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				switch(st.nextToken()) {
					case "1": v += Integer.parseInt(st.nextToken()); break;
					case "2": v -= Integer.parseInt(st.nextToken()); if(v < 0) v = 0;
				}
				
				s += v;
			}
			
			result.append('#').append(tc).append(' ').append(s).append('\n');
		}
		
		System.out.print(result);
	}
}