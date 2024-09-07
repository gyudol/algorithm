import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int cnt = 0, src = 0, des = 1;
		int[] pSum = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) pSum[i] = Integer.parseInt(st.nextToken()) + pSum[i - 1];
		
		while(src <= n && des <= n) {
			int sum = pSum[des] - pSum[src];
			
			if(sum == m) cnt++;
			if(sum >= m) src++;
			else des++;
		}
		
		System.out.print(cnt);
	}
}