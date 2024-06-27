import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = n - 1; i >= 0; i--) {
			for(int j = 0; j < n; j++) {
				if(j >= i) result.append('*');
				else result.append(' ');
			}
			
			result.append('\n');
		}
			
		System.out.print(result);
	}
}