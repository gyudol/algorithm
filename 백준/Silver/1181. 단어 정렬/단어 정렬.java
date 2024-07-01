import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Set<String> words = new HashSet<>();
		
		for(int i = 0; i < n; i++) words.add(br.readLine());
		
		List<String> list = words.stream().collect(Collectors.toList());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		for(String word : list) result.append(word).append('\n');
		
		System.out.print(result);
	}
}