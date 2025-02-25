import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int min;
	static int[][] synergy;
	
	static int getSynergyDiff(boolean[] isFoodA) {
		int sumA = 0, sumB = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(isFoodA[i] && isFoodA[j]) sumA += synergy[i][j] + synergy[j][i];
				else if(!isFoodA[i] && !isFoodA[j]) sumB += synergy[i][j] + synergy[j][i];
			}
		}
		
		return Math.abs(sumA - sumB);
	}
	
	static void dfs(int src, int depth, boolean[] isFoodA) {
		if(depth == N / 2) {
			min = Math.min(min, getSynergyDiff(isFoodA));
			return;
		}
		
		for(int i = src; i < N; i++) {
			isFoodA[i] = true;
			dfs(i + 1, depth + 1, isFoodA);
			isFoodA[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			synergy = new int[N][N];
			
			for(int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) synergy[row][col] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, new boolean[N]);
			result.append('#').append(tc).append(' ').append(min).append('\n');
		}
	
		System.out.print(result);
	}
}