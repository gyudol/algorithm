import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().toUpperCase();
		StringBuilder result = new StringBuilder();
		
		for(char c : line.toCharArray()) {
			result.append(c - 'A' + 1).append(' ');
		}
		
		System.out.print(result);
	}
}