import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 8;
	private static List<List<Integer>> comb;
	private static int N;
	private static int M;
	
	public static void generate(List<Integer> tokens, boolean [] isVisited, int src) {
		if(tokens.size() == M) {
			comb.add(new ArrayList<>(tokens));
			return;
		}
		
		for(int i = src; i <= N; i++) {
			if(isVisited[i]) continue;
			
			isVisited[i] = true;
			tokens.add(i);
			generate(tokens, isVisited, 1);
			tokens.remove(tokens.size() - 1);
			isVisited[i] = false;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();
		comb = new ArrayList<>();
		
		generate(new ArrayList<>(), new boolean [MAX + 1], 1);
		
		for(List<Integer> tokens : comb) {
			for(int num : tokens) result.append(num).append(' ');
			result.append('\n');
		}
		
		System.out.print(result);
	}
}