import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted().toArray();
		
		System.out.print(arr[N / 2]);
	}
}