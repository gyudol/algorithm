import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 240;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		int[][] friends = new int[N + 1][N + 1];
		
		for(int[] row : friends) Arrays.fill(row, MAX);
		for(int i = 1; i <= N; i++) friends[i][i] = 0;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken());
			
			if(src == -1 && des == -1) break;
			
			friends[src][des] = friends[des][src] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
				}
			}
		}

		int min = MAX;
		int[] scores = new int[N + 1];
		List<Integer> candidates = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				scores[i] = Math.max(scores[i], friends[i][j]);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(scores[i] > min) continue;
			if(scores[i] < min) {
				min = scores[i];
				candidates.clear();
			}
			
			candidates.add(i);
		}
		
		result.append(min).append(' ').append(candidates.size()).append('\n');
		for(int candidate : candidates) result.append(candidate).append(' ');
		
		System.out.print(result);
	}
}