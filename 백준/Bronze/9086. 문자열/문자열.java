import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			
			result.append(line.charAt(0)).append(line.charAt(line.length() - 1)).append('\n');
		}
		
		System.out.print(result);
	}
}