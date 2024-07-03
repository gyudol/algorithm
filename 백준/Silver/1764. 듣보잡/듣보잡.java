import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());;
		Set<String> people = new HashSet<>();
		List<String> intersection = new ArrayList<>();
		
		for(int i = 0; i < n; i++) people.add(br.readLine());
		for(int i = 0; i < m; i++) {
			String person = br.readLine();
			
			if(people.contains(person)) intersection.add(person);
		}
		
		Collections.sort(intersection);
		result.append(intersection.size()).append('\n');
		for(String person : intersection) result.append(person).append('\n');
		
		System.out.print(result);
	}
}