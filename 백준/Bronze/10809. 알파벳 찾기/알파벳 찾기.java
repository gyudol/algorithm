import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int LEN = 26;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String word = br.readLine();
		int [] alphabets = new int [LEN];
		
		Arrays.fill(alphabets, -1);
		
		for(int i = 0; i < word.length(); i++) {
			int num = word.charAt(i) - 'a';
			
			if(alphabets[num] == -1) alphabets[num] = i;
		}
		
		for(int idx : alphabets) result.append(idx).append(' ');
		
		System.out.print(result);
	}
}