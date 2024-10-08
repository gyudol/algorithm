import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> sushiMap = new HashMap<>();
		final int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
				k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		int[] belt = new int[N];

		for(int i = 0; i < N; i++) belt[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) sushiMap.put(belt[i], sushiMap.getOrDefault(belt[i], 0) + 1);
		sushiMap.put(c, sushiMap.getOrDefault(c, 0) + 1);
		
		int max = sushiMap.size();
		
		for(int i = k; i < N + k; i++) {
			int removeIdx = (i - k) % N;
			
			sushiMap.put(belt[removeIdx], sushiMap.get(belt[removeIdx]) - 1);
			if(sushiMap.get(belt[removeIdx]) == 0) sushiMap.remove(belt[removeIdx]);
			sushiMap.put(belt[i % N], sushiMap.getOrDefault(belt[i % N], 0) + 1);
			
			max = Math.max(max, sushiMap.size());
			if(max == d) break;
		}
		
		System.out.print(max);
	}
}