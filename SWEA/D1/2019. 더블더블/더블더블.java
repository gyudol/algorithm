import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		int sum = 1;
		
		for(int i = 0; i <= N; i++) {
			result.append(sum).append(' ');
			sum *= 2;
		}
		
		System.out.print(result);
	}
}