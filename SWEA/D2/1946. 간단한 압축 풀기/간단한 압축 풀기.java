import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int WIDTH = 10;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			int pos = 0;
			
			result.append('#').append(tc).append('\n');
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				final char C = st.nextToken().charAt(0);
				final int K = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < K; j++) {
					result.append(C);
					
					if(++pos % WIDTH == 0) result.append('\n');
				}
			}
			
			if(pos % WIDTH != 0) result.append('\n');
		}
		
		System.out.print(result);
	}
}