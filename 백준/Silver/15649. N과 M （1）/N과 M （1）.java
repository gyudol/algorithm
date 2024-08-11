import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 8;
	private static StringBuilder result;
	private static int N;
	private static int M;
	
	public static void generate(int depth, int [] tokens, boolean [] isVisited) {
		if(depth == M) {
			for(int token : tokens) result.append(token).append(' ');
			result.append('\n');
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			tokens[depth] = i;
			
			generate(depth + 1, tokens, isVisited);
			
			isVisited[i] = false;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		result = new StringBuilder();
		
		generate(0, new int [M], new boolean [MAX + 1]);
		
		System.out.print(result);
	}
}