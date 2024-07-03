import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()),
				c = Integer.parseInt(br.readLine());
		
		result.append(a + b - c).append('\n');
		result.append(Integer.parseInt(Integer.toString(a) + Integer.toString(b)) - c);
		
		System.out.print(result);
	}
}