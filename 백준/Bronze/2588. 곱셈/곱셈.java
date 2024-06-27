import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		int val3 = a * (b % 10);
		int val4 = a * (b % 100 / 10);
		int val5 = a * (b / 100);
		
		result.append(val3).append('\n').append(val4).append('\n')
			.append(val5).append('\n').append(val3 + val4 * 10 + val5 * 100);
		
		System.out.print(result);
	}
}