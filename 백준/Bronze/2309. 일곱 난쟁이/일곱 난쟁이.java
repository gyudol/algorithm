import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int LEN = 7;
	private static final int TARGET = 100;
	private static boolean flag;
	private static int[] dwarfs;
	private static int[] realDwarfs;
	
	private static void dfs(int src, int depth, int sum) {
		if(depth == LEN) {
			if(sum == TARGET) flag = true;
			return;
		}
		
		for(int i = src; i < dwarfs.length; i++) {
			if(flag) return;
			
			realDwarfs[depth] = dwarfs[i];
			dfs(i + 1, depth + 1, sum + dwarfs[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		flag = false;
		dwarfs = new int[LEN + 2];
		realDwarfs = new int[LEN];
		
		for(int i = 0; i < dwarfs.length; i++) dwarfs[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(dwarfs);
		dfs(0, 0, 0);
		
		for(int dwarf : realDwarfs) result.append(dwarf).append('\n');
		
		System.out.print(result);
	}
}