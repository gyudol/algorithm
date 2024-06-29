import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static boolean isGroupWord(String word) {
		int [] alphabet = new int [26];
		
		for(int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			alphabet[cur - 'a']++;
			
			if(alphabet[cur - 'a'] > 1 && cur != word.charAt(i - 1)) return false;
		}
		
		return true; 
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(isGroupWord(br.readLine())) cnt++;
		}
		
		System.out.print(cnt);
	}
}
