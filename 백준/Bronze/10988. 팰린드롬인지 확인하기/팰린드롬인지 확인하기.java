import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int isPalindrome(String word) {
		String reversed = new StringBuilder(word).reverse().toString();
		
		return word.equals(reversed) ? 1 : 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		System.out.print(isPalindrome(word));
	}
}