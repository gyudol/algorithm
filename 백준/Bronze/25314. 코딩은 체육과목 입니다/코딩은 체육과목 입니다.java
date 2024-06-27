import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < n / 4; i++) 
			result.append('l').append('o').append('n').append('g').append(" ");
		result.append('i').append('n').append('t');

		System.out.print(result);
	}
}
