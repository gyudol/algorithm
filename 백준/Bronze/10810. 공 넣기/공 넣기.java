import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		int [] basket = new int [n];
		
		for(int cnt = 0; cnt < m; cnt++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1, j = Integer.parseInt(st.nextToken()) - 1,
					k = Integer.parseInt(st.nextToken());
			
			for(int idx = i; idx <= j; idx++) basket[idx] = k;
		}
		
		for(int ball : basket) result.append(ball).append(' ');
			
		System.out.print(result);
	}
}