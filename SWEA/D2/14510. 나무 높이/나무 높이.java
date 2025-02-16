import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static int getMinimumDay(int odd, int even) {
		while(even - odd > 1) {
			odd += 2;
			even--;
		}
		
		if(odd > even) return odd * 2 - 1;
		return even * 2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			final int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int odd = 0, even = 0, max = 0;
			int[] trees = new int[N];
			
			for(int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(trees[i], max);
			}
			
			for(int tree : trees) {
				odd += (max - tree) % 2;
				even += (max - tree) / 2;
			}
			
			result.append('#').append(tc).append(' ').append(getMinimumDay(odd, even)).append('\n');
		}
		
		System.out.println(result);
	}
}