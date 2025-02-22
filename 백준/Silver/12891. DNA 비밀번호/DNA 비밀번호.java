import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static final char[] DNA = {'A', 'C', 'G', 'T'};
	static int[] needed;
	
	static boolean isValid(Map<Character, Integer> terminal) {
		for(int i = 0; i < DNA.length; i++) {
			if(terminal.get(DNA[i]) < needed[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		needed = new int[DNA.length];
		Map<Character, Integer> terminal = new HashMap<>();
		char[] words = br.readLine().toCharArray();
		int src = 0, cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < DNA.length; i++) {
			needed[i] = Integer.parseInt(st.nextToken());
			terminal.put(DNA[i], 0);
		}
		
		for(int des = 0; des < S; des++) {
			terminal.put(words[des], terminal.get(words[des]) + 1);
			
			if(des >= P - 1) {
				if(isValid(terminal)) cnt++;
				terminal.put(words[src], terminal.get(words[src]) - 1);
				src++;
			}
		}
		
		System.out.print(cnt);
	}
}