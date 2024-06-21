import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] tShirts = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		int tPairSum = 0;
		
		for(int tShirt : tShirts) tPairSum += tShirt % T > 0 ? tShirt / T + 1 : tShirt / T;
		result.append(tPairSum).append('\n');
		result.append(N / P).append(' ').append(N % P);
		
		System.out.print(result);
	}
}