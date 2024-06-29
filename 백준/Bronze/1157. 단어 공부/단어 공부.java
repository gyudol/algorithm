import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static char mostUsed(String word) {
		int [] alphabets = new int [26];
		int max = Integer.MIN_VALUE;
		List<Integer> maxIdxList = new ArrayList<>();
		
		for(char c : word.toCharArray()) {
			int num = -1;
			
			if(c >= 'a' && c <= 'z') num = c - 'a';
			else num = c - 'A';
			
			alphabets[num]++;
		}
		
		for(int idx = 0; idx < alphabets.length; idx++) {
			if(alphabets[idx] == max) maxIdxList.add(idx);
			
			if(alphabets[idx] > max) {
				maxIdxList.clear();
				maxIdxList.add(idx);
				max = alphabets[idx];
			}
		}
		
		return (maxIdxList.size() == 1) ? (char) (maxIdxList.get(0) + 'A') : '?';
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		System.out.print(mostUsed(word));
	}
}
