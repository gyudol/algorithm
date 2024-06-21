import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Map<String, Integer> wordMap = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			
			if(word.length() < M) continue;
			
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
		}

		List<String> wordBook = new ArrayList<>(wordMap.keySet());
		Collections.sort(wordBook, (w1, w2) -> {
			if(wordMap.get(w1) == wordMap.get(w2)) {
				if(w1.length() == w2.length()) return w1.compareTo(w2);
				
				return Integer.compare(w2.length(), w1.length());
			}
			
			return Integer.compare(wordMap.get(w2), wordMap.get(w1));
		});
		
		for(String word : wordBook) result.append(word).append('\n');
		
		System.out.print(result);
	}
}