import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int LEN = 5;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int [] arr = new int [LEN];
		int sum = 0;
		
		for(int i = 0; i < LEN; i++) sum += arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		result.append(sum / LEN).append('\n').append(arr[LEN / 2]);
		
		System.out.print(result);
	}
}