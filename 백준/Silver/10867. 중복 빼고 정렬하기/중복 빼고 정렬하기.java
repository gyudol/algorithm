import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] seq = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted()
				.distinct().toArray();
		
		for(int num : seq) result.append(num).append(' ');
		
		System.out.print(result);
	}
}