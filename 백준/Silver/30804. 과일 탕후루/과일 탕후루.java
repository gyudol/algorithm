import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_SIZE = 2;
	private static int n;
	private static int [] fruits;
	
	private static int twoPointer() {
		Map<Integer, Integer> terminals = new HashMap<>();
		int src = 0, cnt = 0, result = -1;
		
		for(int des = 0; des < n; des++) {
			terminals.put(fruits[des], terminals.getOrDefault(fruits[des], 0) + 1);
			cnt++;
			
			while(src < n - 1 && terminals.size() > MAX_SIZE) {
				terminals.put(fruits[src], terminals.get(fruits[src]) - 1);
				if(terminals.get(fruits[src]) == 0) terminals.remove(fruits[src]);
				src++;	cnt--;
			}
			
			result = Math.max(cnt, result);
		}
		
		return result;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		fruits = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) fruits[i] = Integer.parseInt(st.nextToken());
		
		System.out.print(twoPointer());
	}
}