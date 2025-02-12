import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int LEN = 9;
	private static final int TARGET = 100;
	
	private static void remove(int[] dwarfs, int sum) {
		for(int i = 0; i < LEN - 1; i++) {
			for(int j = i + 1; j < LEN; j++) {
				if(sum - dwarfs[i] - dwarfs[j] == TARGET) {
					dwarfs[i] = dwarfs[j] = -1;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int sum = 0;
		int[] dwarfs = new int[LEN];
		
		for(int i = 0; i < LEN; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		
		Arrays.sort(dwarfs);
		remove(dwarfs, sum);
		
		for(int height : dwarfs) {
			if(height != -1) result.append(height).append('\n');
		}
		
		System.out.print(result);
	}
}