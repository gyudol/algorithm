import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) result.append('*');
			result.append('\n');
		}
			
		System.out.print(result);
	}
}