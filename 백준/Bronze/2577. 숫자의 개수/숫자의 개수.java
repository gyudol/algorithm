import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine()),
				c = Integer.parseInt(br.readLine());
		int [] counts = new int [10];
		int sum = a * b * c;
		
		while(sum > 0) {	// 100 <= a, b, c < 1000
			counts[sum % 10]++;
			sum /= 10;
		}
		
		for(int count : counts) result.append(count).append('\n');
		
		System.out.print(result);
	}
}