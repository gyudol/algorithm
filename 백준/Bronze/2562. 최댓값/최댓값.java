import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int LEN = 9;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE, maxIdx = -1;
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= LEN; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > max) {
				max = num;
				maxIdx = i;
			}
		}
		
		result.append(max).append('\n').append(maxIdx);
			
		System.out.print(result);
	}
}