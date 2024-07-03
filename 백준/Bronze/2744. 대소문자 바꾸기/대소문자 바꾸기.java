import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int OFFSET = 'a' - 'A';
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		for(char c : br.readLine().toCharArray()) {
			if(c >= 'A' && c <= 'Z') result.append((char) (c + OFFSET));
			else result.append((char) (c - OFFSET));
		}
		
		System.out.print(result);
	}
}