import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] opinions = new int [n];
		
		for(int i = 0; i < n; i++) opinions[i] = Integer.parseInt(br.readLine());
		
		int div15 = (int) Math.round(n * 0.15);
		int start = div15, end = n - div15 - 1;		// [start, end]
		int sum = 0;
		
		Arrays.sort(opinions);
		for(int i = start; i <= end; i++) sum += opinions[i];
		System.out.print((int) Math.round(sum * 1.0 / (n - 2 * div15)));
	}
}