import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static StringBuilder result;
	
	private static void generate(int depth, int [] tokens) {
		if(depth == M) {
			for(int num : tokens) result.append(num).append(' ');
			result.append('\n');
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			tokens[depth] = i;
			
			generate(depth + 1, tokens);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		result = new StringBuilder();
		
		generate(0, new int [M]);
		
		System.out.print(result);
	}
}