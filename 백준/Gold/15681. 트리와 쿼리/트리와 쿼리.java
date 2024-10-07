import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int R;
	private static ArrayList<ArrayList<Integer>> tree;
	private static boolean[] isVisited;
	private static int[] subtreeSize;
	
	private static int dfs(int parent) {
		if(subtreeSize[parent] != -1) return subtreeSize[parent];
		if(isVisited[parent]) return 0;
		isVisited[parent] = true;
		int cnt = 1;
		
		for(int child : tree.get(parent)) cnt += dfs(child);
		
		return subtreeSize[parent] = cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
		final int Q = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();
		isVisited = new boolean[N + 1];
		subtreeSize = new int[N + 1];
		
		Arrays.fill(subtreeSize, -1);
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken());
			
			tree.get(src).add(des);
			tree.get(des).add(src);
		}
		
		dfs(R);
		for(int i = 0; i < Q; i++) result.append(dfs(Integer.parseInt(br.readLine()))).append('\n');
		
		System.out.print(result);
	}
}