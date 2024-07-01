import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final int MAX = 10000;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int [] counts = new int [MAX + 1];
		
		for(int i = 0; i < n; i++) counts[Integer.parseInt(br.readLine())]++;
		for(int i = 1; i <= MAX; i++) {
			for(int j = 0; j < counts[i]; j++) result.append(i).append('\n');
		}
		
		System.out.print(result);
	}
}