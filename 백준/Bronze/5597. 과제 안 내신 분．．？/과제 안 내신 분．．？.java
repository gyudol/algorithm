import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int LEN = 30;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int [] assignment = new int [LEN + 1];
		
		for(int i = 0; i < LEN - 2; i++) assignment[Integer.parseInt(br.readLine())]++;
		
		for(int i = 1; i <= LEN; i++) {
			if(assignment[i] == 0) result.append(i).append('\n');
		}
			
		System.out.print(result);
	}
}