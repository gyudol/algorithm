import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int DEGREE = 3;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		long n = Long.parseLong(br.readLine());
		
		// Math.pow로 계산시 너무 큰 숫자는 오차 범위 존재
		result.append(n * n * n).append('\n').append(DEGREE);
		
		System.out.print(result);
	}
}