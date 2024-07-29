import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 4;
	private static int n;
	private static int [] a;
	private static int [] operators;
	private static int min;
	private static int max;
	
	private static void dfs(int value, int depth) {
		if(depth == n) {
			min = Math.min(value, min);
			max = Math.max(value, max);
			
			return;
		}
		
		for(int i = 0; i < LEN; i++) {
			if(operators[i] == 0) continue;
			operators[i]--;
			
			switch(i) {
				case 0: dfs(value + a[depth], depth + 1); break;
				case 1: dfs(value - a[depth], depth + 1); break;
				case 2: dfs(value * a[depth], depth + 1); break;
				case 3: dfs(value / a[depth], depth + 1); break;
			}
			
			operators[i]++;
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int [n];
		operators = new int [LEN];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length; i++) a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < LEN; i++) operators[i] = Integer.parseInt(st.nextToken());
		
		dfs(a[0], 1);
		
		result.append(max).append('\n').append(min);
		
		System.out.print(result);
	}
}