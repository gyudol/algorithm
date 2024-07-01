import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String ox = br.readLine();
			int score = 0, con = 0;
			
			for(char c : ox.toCharArray()) {
				if(c == 'O') score += ++con;
				else con = 0;
			}
			
			result.append(score).append('\n');
		}
		
		System.out.print(result);
	}
}