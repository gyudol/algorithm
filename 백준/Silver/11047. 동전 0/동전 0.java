import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int idx = n - 1, cnt = 0;
		int [] coins = new int [n];
		
		for(int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
		
		while(k > 0) {
			cnt += k / coins[idx];
			k %= coins[idx--];
		}
		
		System.out.print(cnt);
	}
}