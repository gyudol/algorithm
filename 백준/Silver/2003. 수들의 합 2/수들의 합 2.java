import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] arr = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int src = 0; src < n; src++) {
			int sum = 0;
			
			for(int des = src; des < n; des++) {
				sum += arr[des];
				
				if(sum == m) cnt++;
				if(sum >= m) break;
			}
		}
		
		System.out.print(cnt);
	}
}