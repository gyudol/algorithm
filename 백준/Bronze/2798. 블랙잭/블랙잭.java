import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int [] cards = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).sorted().toArray();
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					
					if(sum > m) break;
					
					max = Math.max(max, sum);
				}
			}
		}
		
		System.out.print(max);
	}
}