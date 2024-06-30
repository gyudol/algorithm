import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int DEGREE = 1;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		result.append((int) Math.pow(n, DEGREE)).append('\n').append(DEGREE);
		
		System.out.print(result);
	}
}