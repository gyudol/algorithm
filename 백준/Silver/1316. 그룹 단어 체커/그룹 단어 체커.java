import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			boolean [] isVisited = new boolean [26];
			boolean isGroupWord = true;
			
			for(int j = 0; j < word.length(); j++) {
				char cur = word.charAt(j);
				
				if(isVisited[cur - 'a']) {
					isGroupWord = false;
					break;
				}
				isVisited[cur - 'a'] = true;
				
				while(j + 1 < word.length() && cur == word.charAt(j+1)) j++;
			}
			
			if(isGroupWord) cnt++;
		}
		
		System.out.print(cnt);
	}
}