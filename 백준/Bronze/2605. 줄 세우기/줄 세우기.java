import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		List<Integer> seq = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int src = 0; src < N; src++) {
			int target = src - Integer.parseInt(st.nextToken());
			
			seq.add(target, src + 1);
		}
		
		for(int num : seq) result.append(num).append(' ');
		
		System.out.print(result);
	}
}