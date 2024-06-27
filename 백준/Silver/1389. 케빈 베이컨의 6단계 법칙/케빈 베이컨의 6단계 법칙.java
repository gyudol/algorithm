import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 다익스트라와 달리 시작 지점이 정해져 있지 않고 모두와의 관계를 확인 => Floyd-Warshall
	private static final int MAX = 101;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] graph = new int [N+1][N+1];
		
		for(int [] row : graph) Arrays.fill(row, MAX);
		for(int i = 1; i <= N; i++) graph[i][i] = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++)
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
		
		int min = Integer.MAX_VALUE;
		int result = -1;
		
		for(int src = 1; src <= N; src++) {
			int sum = 0;
			
			for(int des = 1; des <= N; des++) sum += graph[src][des];
			
			if(sum < min) {
				min = sum;
				result = src;
			}
		}
		
		System.out.print(result);
	}
}