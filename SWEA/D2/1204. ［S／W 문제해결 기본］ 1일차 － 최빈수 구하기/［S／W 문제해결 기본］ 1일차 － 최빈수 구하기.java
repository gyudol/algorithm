import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int LEN = 1000;
	private static final int MAX = 100;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		int tc = 0;
		
		while(tc < T) {
			tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] scores = new int [MAX + 1];
			int mode = Integer.MIN_VALUE, modeNum = -1;
			
			for(int i = 0; i < LEN; i++) scores[Integer.parseInt(st.nextToken())]++;
			
			for(int i = 0; i < scores.length; i++) {
				if(scores[i] >= mode) {
					mode = scores[i];
					modeNum = i;
				}
			}
			
			result.append('#').append(tc).append(' ').append(modeNum).append('\n');
		}
		
		System.out.print(result);
	}
}