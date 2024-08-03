import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder result;
	private static int [] numbers;
	
	private static void permutation(int n, int m, List<Integer> list) {
		if(list.size() == m) {
			for(int num : list) result.append(num).append(' ');
			result.append('\n');
			return;
		}
		
		for(int number : numbers) {
			if(list.contains(number)) continue;
			
			list.add(number);
			permutation(n, m, list);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		numbers = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		permutation(n, m, new ArrayList<>());
		
		System.out.print(result);
	}
}