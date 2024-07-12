import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int sum = 1;
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothesMap = new HashMap<>();

			for(int i = 0; i < n; i++) {
				String [] clothing = br.readLine().split(" ");
				
				clothesMap.put(clothing[1], clothesMap.getOrDefault(clothing[1], 0) + 1);
			}
			
			// 안 입는 경우 있으므로 + 1 => 모든 경우 n+1C1 곱해주고 아예 안 입는 경우 빼줌
			for(String key : clothesMap.keySet()) sum *= clothesMap.get(key) + 1;
			
			result.append(sum - 1).append('\n');
		}
		
		System.out.print(result);
	}
}