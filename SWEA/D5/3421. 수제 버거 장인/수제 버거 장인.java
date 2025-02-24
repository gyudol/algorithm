import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static ArrayList<Set<Integer>> constraints;
	
	static int countComb(int src, int[] isVisited) {
		int cnt = 1;
		
		for(int u = src; u <= N; u++) {
			if(isVisited[u] > 0) continue;
			
			isVisited[u]++;
			for(int v : constraints.get(u)) isVisited[v]++;
			
			cnt += countComb(u + 1, isVisited);
			
			isVisited[u]--;
			for(int v : constraints.get(u)) isVisited[v]--;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			final int M = Integer.parseInt(st.nextToken());
			constraints = new ArrayList<>();
			
			for(int i = 0; i <= N; i++) constraints.add(new HashSet<>());
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				
				constraints.get(u).add(v);
				constraints.get(v).add(u);
			}
			
			result.append('#').append(tc).append(' ')
				.append(countComb(1, new int[N + 1])).append('\n');
		}
		
		System.out.println(result);
	}
}