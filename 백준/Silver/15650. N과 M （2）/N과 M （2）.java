import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static StringBuilder result = new StringBuilder();
	static int N, M;
	
	static void combination(int depth, int src, int[] seq) {
		if(depth == M) {
			for(int num : seq) result.append(num).append(' ');
			result.append('\n');
			return;
		}
		
		for(int i = src; i <= N; i++) {
			seq[depth] = i;
			combination(depth + 1, i + 1, seq);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		
		combination(0, 1, new int[M]);
		System.out.print(result);
	}
}