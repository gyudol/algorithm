import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder result;
	private static int N;
	private static int M;
	private static int[] numbers;
	
	private static void comp(int src, int depth, int[] seq) {
		if(depth == M) {
			for(int num : seq) result.append(num).append(' ');
			result.append('\n');
			return;
		}
		
		int last = 0;
		for(int i = src; i < N; i++) {
			if(numbers[i] == last) continue;
			
			seq[depth] = numbers[i];
			comp(i, depth + 1, seq);
			last = numbers[i];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		comp(0, 0, new int[M]);
		
		System.out.print(result);
	}
}