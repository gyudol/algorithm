import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] trees = new int [n];
		
		for(int i = 0; i < n; i++) trees[i] = Integer.parseInt(br.readLine());
		
		int distGcd = trees[1] - trees[0];
		for(int i = 2; i < trees.length; i++) distGcd = gcd(distGcd, trees[i] - trees[i - 1]);
		
		int need = (trees[n - 1] - trees[0]) / distGcd + 1 - trees.length;
		
		System.out.print(need);
	}
}