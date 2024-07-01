import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 5;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		for(int i = 0; i < LEN; i++) 
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		
		System.out.print(sum % 10);
	}
}