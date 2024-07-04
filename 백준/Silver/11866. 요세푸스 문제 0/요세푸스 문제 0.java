import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()) - 1;
		int cur = 0;
		List<Integer> circle = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
		List<Integer> josephus = new ArrayList<>();
		
		while(!circle.isEmpty()) {
			cur = (cur + k) % circle.size();
			josephus.add(circle.remove(cur));
		}
		
		System.out.print(josephus.toString().replace("[", "<").replace("]", ">"));
	}
}