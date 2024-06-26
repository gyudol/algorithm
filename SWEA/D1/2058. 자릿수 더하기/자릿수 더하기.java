import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int sum = 0;
		
		for(char c : N.toCharArray()) {
			sum += c - '0';
		}
		
		System.out.print(sum);
	}
}