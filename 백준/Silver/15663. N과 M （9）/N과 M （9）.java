import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder result;
	private static int n;
	private static int m;
	private static int [] numbers;
	
	private static void dfs(int depth, int [] seq, boolean [] isVisited) {
		if(depth == m) {
			for(int num : seq) result.append(num).append(' ');
			result.append('\n');
			
			return;
		}
		
		int before = 0;	// 동일 depth에서 같은 값을 선택 못하게
		for(int i = 0; i < n; i++) {
			if(isVisited[i] || before == numbers[i]) continue;
			isVisited[i] = true;
			seq[depth] = before = numbers[i];
			
			dfs(depth + 1, seq, isVisited);

			isVisited[i] = false;
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
		
		dfs(0, new int [m], new boolean [n]);
		
		System.out.print(result);
	}
}