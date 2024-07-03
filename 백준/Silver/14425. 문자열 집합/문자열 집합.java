import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		Set<String> words = new HashSet<>();
		
		for(int i = 0; i < n; i++) words.add(br.readLine());
		for(int i = 0; i < m; i++) {
			if(words.contains(br.readLine())) cnt++;
		}
		
		System.out.print(cnt);
	}
}