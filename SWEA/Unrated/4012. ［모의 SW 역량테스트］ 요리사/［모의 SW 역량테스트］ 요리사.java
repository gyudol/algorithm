import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int min;
	static int[][] ingredients;
	
	static int getSynergy(boolean[] isSelected, boolean flag) {
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i] == flag) continue;
			
			for(int j = 0; j < N; j++) {
				if(isSelected[j] == flag) continue;
				
				sum += ingredients[i][j];
			}
		}
		
		return sum;
	}
	
	static void getMinDifference(int src, int depth, boolean[] isSelected) {
		if(depth == N / 2) {
			min = Math.min(min, Math.abs(getSynergy(isSelected, true) - getSynergy(isSelected, false)));
			return;
		}
		
		for(int i = src; i < N; i++) {
			isSelected[i] = true;
			getMinDifference(i + 1, depth + 1, isSelected);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			ingredients = new int[N][N];
			
			for(int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int col = 0; col < N; col++) ingredients[row][col] = Integer.parseInt(st.nextToken());
			}
			
			getMinDifference(0, 0, new boolean[N]);
			result.append('#').append(tc).append(' ').append(min).append('\n');
		}
	
		System.out.print(result);
	}
}