import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int LEN = 5;
	private static final int MAX = 15;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String [] words = new String [LEN];
		
		for(int i = 0; i < LEN; i++) words[i] = br.readLine();
		
		for(int col = 0; col < MAX; col++) {
			for(int row = 0; row < LEN; row++) {
				if(words[row].length() - 1 < col) continue;
				
				result.append(words[row].charAt(col));
			}
		}
		
		System.out.print(result);
	}
}