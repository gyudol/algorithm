import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int [] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		StringBuilder result = new StringBuilder();
		
		for(int num : arr) {
			if(num < x) result.append(num).append(' ');
		}
			
		System.out.print(result);
	}
}