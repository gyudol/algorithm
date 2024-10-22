import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	private static final int LEN = 10;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int k = 0;
			final int N = Integer.parseInt(br.readLine());
			Set<Character> set = new HashSet<>();
			
			while(true) {
				int sheepCnt = ++k * N;
				
				for(char c : Integer.toString(sheepCnt).toCharArray()) set.add(c);
				
				if(set.size() == LEN) break;
			}
			
			result.append('#').append(tc).append(' ').append(k * N).append('\n');
		}
		
		System.out.print(result);
	}
}