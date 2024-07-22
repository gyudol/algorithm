import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> sites = new HashMap<>();
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			sites.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < m; i++) result.append(sites.get(br.readLine())).append('\n');
		
		System.out.print(result);	
	}
}