import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt).sum();
		
		System.out.print(sum);
	}
}