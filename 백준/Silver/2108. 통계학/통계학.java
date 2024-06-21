import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	private static int findMode(int [] numbers) {
		Map<Integer, Integer> terminals = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		
		for(int number : numbers) terminals.put(number, terminals.getOrDefault(number, 0) + 1);

		for(int key : terminals.keySet()) {
			int value = terminals.get(key);
			
			if(value < max) continue;
			if(value > max) {
				list.clear();
				max = value;
			}
			list.add(key);
		}
		
		Collections.sort(list);
		
		return (list.size() > 1) ? list.get(1) : list.get(0);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] numbers = new int [N];
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		
		Arrays.sort(numbers);
		result.append((int) Math.round(sum * 1.0 / N)).append('\n')
			.append(numbers[N / 2]).append('\n')
			.append(findMode(numbers)).append('\n')
			.append(numbers[numbers.length-1] - numbers[0]);
		
		
		System.out.print(result);
	}
}