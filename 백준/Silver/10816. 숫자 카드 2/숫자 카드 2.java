import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(br.readLine());;
		Map<Integer, Integer> hand = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			
			hand.put(card, hand.getOrDefault(card, 0) + 1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) 
			result.append(hand.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(' ');
		
		System.out.print(result);
	}
}