import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		int [] basket = new int [n + 1];
		
		for(int i = 1; i <= n; i++) basket[i] = i;
		
		for(int cnt = 0; cnt < m; cnt++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
			
			int tmp = basket[i];
			basket[i] = basket[j];
			basket[j] = tmp;
		}
		
		for(int i = 1; i <= n; i++) result.append(basket[i]).append(' ');
			
		System.out.print(result);
	}
}