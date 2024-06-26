import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) result.append(i).append(' ');
		}
		
		System.out.print(result);
	}
}