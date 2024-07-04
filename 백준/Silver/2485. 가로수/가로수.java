import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] trees = new int [n];
		int [] dist = new int [n - 1];
		
		for(int i = 0; i < n; i++) trees[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < dist.length; i++) dist[i] = trees[i + 1] - trees[i];
		
		int distGcd = dist[0];
		for(int i = 1; i < dist.length; i++) distGcd = gcd(distGcd, dist[i]);
		
		int cnt = 0;
		for(int i = 0; i < dist.length; i++) cnt += (dist[i] - distGcd) / distGcd;
		
		System.out.print(cnt);
	}
}