import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] sum = new int [n + 1];
		
		for(int i = 1; i <= n; i++) 
			sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken()), des = Integer.parseInt(st.nextToken());
		
			result.append(sum[des] - sum[src - 1]).append('\n');
		}
		
		System.out.print(result);
	}
}