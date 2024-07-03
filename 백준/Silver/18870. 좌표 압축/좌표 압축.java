import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int [] numbers = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int [] sorted = Arrays.stream(numbers).sorted().toArray();
		int rank = 0, last = Integer.MAX_VALUE;
		Map<Integer, Integer> smaller = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			if(last == sorted[i]) continue;
			
			last = sorted[i];
			smaller.put(last, rank++);
		}
		
		for(int num : numbers) result.append(smaller.get(num)).append(' ');
		
		System.out.print(result);
	}
}