import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int [] basket;
	
	private static void swapRange(int src, int des) {
		for(int i = src, j = des; i <= (src + des) / 2; i++, j--) {
			int tmp = basket[i];
			basket[i] = basket[j];
			basket[j] = tmp;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		basket = new int [N + 1];
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= N; i++) basket[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			swapRange(a, b);
		}
		
		for(int i = 1; i <= N; i++) result.append(basket[i]).append(' ');
		
		System.out.print(result);
	}
}