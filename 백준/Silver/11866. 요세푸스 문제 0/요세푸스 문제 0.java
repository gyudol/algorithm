import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder().append('<');
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()) - 1;
		int cur = 0;
		List<Integer> josephus = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) josephus.add(i);
		
		while(josephus.size() > 1) {
			cur = (cur + k) % josephus.size();
			result.append(josephus.remove(cur)).append(',').append(' ');
		}
		result.append(josephus.remove(0)).append('>');
		
		System.out.print(result);
	}
}