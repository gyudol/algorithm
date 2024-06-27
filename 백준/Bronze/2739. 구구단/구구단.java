import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= 9; i++) {
			result.append(N).append(' ').append('*').append(' ').append(i)
				.append(' ').append('=').append(' ').append(N * i).append('\n');
		}

		System.out.print(result);
	}
}