import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int sum = 1;
		
		for(int i = n; i > n - k; i--) sum *= i;
		for(int i = k; i > 1; i--) sum /= i;
		
		System.out.print(sum);
	}
}