import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int [] div = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted().toArray();
		
		System.out.print(div[0] * div[len - 1]);
	}
}