import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			String line = br.readLine();
			
			if(line == null) break;
			
			result.append(line).append('\n');
		}
		
		System.out.print(result);
	}
}