import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(n * (n + 1) / 2);
	}
}