import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder result;
	private static int n;
	private static int m;
	private static int [] numbers;
	
	private static void dfs(int depth, String seq, boolean [] isVisitedIdx, Set<String> isVisitedSeq) {
		if(depth == m) {
			if(isVisitedSeq.contains(seq)) return;
			isVisitedSeq.add(seq);
			
			result.append(seq).append('\n');
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(isVisitedIdx[i]) continue;
			isVisitedIdx[i] = true;
			
			dfs(depth + 1, seq + numbers[i] + ' ', isVisitedIdx, isVisitedSeq);

			isVisitedIdx[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		numbers = new int [n];
		
		for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		
		dfs(0, "", new boolean [n], new HashSet<>());
		
		System.out.print(result);
	}
}