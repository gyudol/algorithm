import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int [] money = {25, 10, 5, 1};
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int cent = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < money.length; i++) {
				result.append(cent / money[i]).append(' ');
				cent %= money[i];
			}
			
			result.append('\n');
		}
		
		System.out.print(result);
	}
}