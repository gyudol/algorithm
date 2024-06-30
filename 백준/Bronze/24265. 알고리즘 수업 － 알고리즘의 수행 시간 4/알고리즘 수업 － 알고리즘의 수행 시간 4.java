import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX_DEGREE = 2;	
	// n = 7 => 6회 + 5회 + 4회 + 3회 + 2회 + 1회	=> n * (n - 1) / 2
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		result.append(n * (n - 1L) / 2).append('\n').append(MAX_DEGREE);
		
		System.out.print(result);
	}
}