import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 9;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int row = -1, col = -1, max = Integer.MIN_VALUE;
		
		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < LEN; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num > max) {
					max = num;
					row = i + 1;	col = j + 1;
				}
			}
		}
		
		result.append(max).append('\n').append(row).append(' ').append(col);
		
		System.out.print(result);
	}
}