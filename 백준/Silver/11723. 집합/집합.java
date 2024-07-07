import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 20;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "add": set.add(Integer.parseInt(st.nextToken())); break;
				case "remove": set.remove(Integer.parseInt(st.nextToken())); break;
				case "check": result.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0)
					.append('\n'); break;
				case "toggle": {
					int x = Integer.parseInt(st.nextToken());
					
					if(set.contains(x)) set.remove(x);
					else set.add(x);
					
					break;
				}
				case "all": {
					set.clear();
					for(int x = 1; x <= MAX; x++) set.add(x);
					break;
				}
				case "empty": set.clear(); break;
			}
		}
		
		System.out.print(result);
	}
}