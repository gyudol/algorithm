import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int src = 0, des = k, max = Integer.MIN_VALUE;
		int[] temp = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) temp[i] = Integer.parseInt(st.nextToken()) + temp[i - 1];
		
		while(des <= n) {
			int sum = temp[des] - temp[src];
			
			max = Math.max(sum, max);
			src++;	des++;
		}
		
		System.out.print(max);
	}
}