import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		int start = n, end = n;
		boolean flag = false;
		
		for(int i = 1; i <= 2 * n - 1; i++) {
			for(int j = 1; j < start; j++) result.append(' ');
			for(int j = start; j <= end; j++) result.append('*');
			result.append('\n');
			
			if(end == 2 * n - 1) flag = true;
			if(flag) {
				start++;	end--;
			}
			else {
				start--;	end++;
			}
		}
		
		System.out.print(result);
	}
}