import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static String isPalindrome(String number) {
		String reversed = new StringBuilder(number).reverse().toString();
		
		return number.equals(reversed) ? "yes" : "no";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		while(true) {
			String number = br.readLine();
			if(number.equals("0")) break;
			
			result.append(isPalindrome(number)).append('\n');
		}
		
		System.out.print(result);
	}
}