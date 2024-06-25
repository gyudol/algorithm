import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static StringBuilder result;
	
	private static void generate(List<Integer> tokens) {
		if(tokens.size() == M) {
			for(int num : tokens) result.append(num).append(' ');
			result.append('\n');
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			tokens.add(i);
			generate(tokens);
			tokens.remove(tokens.size() - 1);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		result = new StringBuilder();
		
		generate(new ArrayList<>());
		System.out.print(result);
	}
}