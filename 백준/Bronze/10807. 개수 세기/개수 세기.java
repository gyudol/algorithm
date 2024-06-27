import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int v = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int num : arr) {
			if(num == v) cnt++;
		}
			
		System.out.print(cnt);
	}
}