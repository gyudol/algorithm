import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int S;
	private static int[] seq;
	private static int result;
	
	private static void dfs(int src, int sum) {
		if(sum == S) result++;
		
		for(int i = src; i < N; i++) dfs(i + 1, sum + seq[i]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
		result = 0;
		seq = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		dfs(0, 0);
		System.out.print(S == 0 ? --result : result);
	}
}