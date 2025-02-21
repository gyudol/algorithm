import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N, L;
	static int[][] ingredients;
	
	static int hamburgerDiet(int src, int totalScore, int totalCalorie) {
		if(totalCalorie > L) return 0;
		
		int max = totalScore;
		
		for(int i = src; i < N; i++) {
			max = Math.max(hamburgerDiet(i + 1, totalScore + ingredients[i][0], 
					totalCalorie + ingredients[i][1]), max);
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	L = Integer.parseInt(st.nextToken());
			ingredients = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}	
			
			result.append('#').append(tc).append(' ').append(hamburgerDiet(0, 0, 0)).append('\n');
		}

		System.out.print(result);
	}
}