import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder result;
	private static int[] seq;
	private static int n;
	private static int m;
	
	private static void dfs(int src, int depth, int[] comb) {
		if(depth == m) {
			for(int num : comb) result.append(num).append(' ');
			result.append('\n');
			
			return;
		}
		
		for(int i = src; i < n; i++) {
			comb[depth] = seq[i];
			
			dfs(i, depth + 1, comb);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		seq = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted().toArray();
		
		dfs(0, 0, new int[m]);
		System.out.print(result);
	}
}