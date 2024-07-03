import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String person = st.nextToken(), record = st.nextToken();
			
			if(record.equals("enter")) set.add(person);
			else set.remove(person);
		}
		
		String [] company = set.stream().sorted((s1, s2) -> s2.compareTo(s1)).toArray(String [] :: new);
		for(String person : company) result.append(person).append('\n');
		
		System.out.print(result);
	}
}