import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 1501;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				R = Integer.parseInt(st.nextToken());
		int result = 0;
		final int[] values = new int[N + 1];
		int[][] graph = new int[N + 1][N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) values[i] = Integer.parseInt(st.nextToken());
		
		for(int row = 1; row <= N; row++) {
			Arrays.fill(graph[row], MAX);
			graph[row][row] = 0;
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken()),
					len = Integer.parseInt(st.nextToken());
			
			graph[v1][v2] = graph[v2][v1] = len;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		for(int src = 1; src <= N; src++) {
			int itemCnt = 0;
			
			for(int des = 1; des <= N; des++) {
				if(graph[src][des] <= M) itemCnt += values[des];
			}
			
			result = Math.max(itemCnt, result);
		}
		
		System.out.print(result);
	}
}