import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int moveComb(int n) {
		int end = 1, move = 1;
		
		while(end < n) end += 6 * move++;
			
		return move;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(moveComb(n));
	}
}