import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] a = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int[] b = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).boxed()
				.sorted((n1, n2) -> Integer.compare(n2, n1))
				.mapToInt(Integer::intValue).toArray();
		
		Arrays.sort(a);
		
		for(int i = 0; i < n; i++) sum += a[i] * b[i];
		
		System.out.print(sum);
	}
}