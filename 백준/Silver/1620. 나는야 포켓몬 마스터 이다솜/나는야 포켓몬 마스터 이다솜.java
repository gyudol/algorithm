import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static boolean isNumber(String str) {
		char c = str.charAt(0);
		
		return c >= '0' && c <= '9';
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		Map<Integer, String> bookToName = new HashMap<>();
		Map<String, Integer> bookToNum = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			String pokemon = br.readLine();
			
			bookToName.put(i, pokemon);
			bookToNum.put(pokemon, i);
		}
		
		for(int i = 0; i < m; i++) {
			String find = br.readLine();
			
			if(isNumber(find)) result.append(bookToName.get(Integer.parseInt(find))).append('\n');
			else result.append(bookToNum.get(find)).append('\n');
		}
		
		System.out.print(result);
	}
}