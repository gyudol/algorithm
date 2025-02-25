import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static boolean[][] constraints;
	
	static void visit(int u, int op, int[] isVisited) {
		isVisited[u] += op;
		
		for(int v = 0; v < constraints[u].length; v++) {
			if(constraints[u][v]) isVisited[v] += op;
		}
	}
	
	static int countComb(int src, int[] isVisited) {
		int cnt = 1;
		
		for(int u = src; u <= N; u++) {
			if(isVisited[u] > 0) continue;
			
			visit(u, 1, isVisited);
			cnt += countComb(u + 1, isVisited);
			visit(u, -1, isVisited);
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
			constraints = new boolean[N + 1][N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				
				constraints[u][v] = constraints[v][u] = true;
			}
			
			result.append('#').append(tc).append(' ')
				.append(countComb(1, new int[N + 1])).append('\n');
		}
		
		System.out.print(result);
	}
}