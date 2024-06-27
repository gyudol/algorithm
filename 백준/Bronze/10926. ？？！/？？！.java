import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder result = new StringBuilder();
		
		result.append(line).append('?').append('?').append('!');
		
		System.out.print(result);
	}
}