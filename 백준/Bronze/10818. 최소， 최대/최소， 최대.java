import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num < min) min = num;
			if(num > max) max = num;
		}
		
		result.append(min).append(' ').append(max);
			
		System.out.print(result);
	}
}