import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static final int OPERATORS = 4;
	
	static int N;
	static int[] operands;
	static int max, min;
	
	static int calculate(int x, int y, int op) {
		switch(op) {
			case 0: return x + y;
			case 1: return x - y;
			case 2: return x * y;
			default: return x / y;
		}
	}
	
	static void generate(int depth, int sum, int[] opCnts) {
		if(depth == N) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		for(int i = 0; i < OPERATORS; i++) {
			if(opCnts[i] == 0) continue;
			
			opCnts[i]--;
			generate(depth + 1, calculate(sum, operands[depth], i), opCnts);
			opCnts[i]++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[] opCnts = new int[OPERATORS];
			operands = new int[N];
			max = Integer.MIN_VALUE;	min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < OPERATORS; i++) opCnts[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) operands[i] = Integer.parseInt(st.nextToken());
			
			generate(1, operands[0], opCnts);
			result.append('#').append(tc).append(' ').append(max - min).append('\n');
		}
		
		System.out.print(result);
	}
}