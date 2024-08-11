import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 10000;
	private static StringBuilder result;
	private static int n;
	private static int m;
	private static int [] numbers;
	
	private static void permutation(int depth, int [] seq, boolean [] isVisited) {
		if(depth == m) {
			for(int num : seq) result.append(num).append(' ');
			result.append('\n');
			
			return;
		}
		
		for(int number : numbers) {
			if(isVisited[number]) continue;
			isVisited[number] = true;
			seq[depth] = number;
			
			permutation(depth + 1, seq, isVisited);
			
			isVisited[number] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		numbers = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		
		permutation(0, new int [m], new boolean [MAX + 1]);
		
		System.out.print(result);
	}
}