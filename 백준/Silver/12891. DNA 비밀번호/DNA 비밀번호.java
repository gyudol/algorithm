import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final char[] DNA = {'A', 'C', 'G', 'T'};
	static int[] needed;
	
	static boolean isValid(int[] state) {
		for(int i = 0; i < DNA.length; i++) {
			if(state[DNA[i]] < needed[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		needed = new int[DNA.length];
		int[] state = new int['Z'];
		char[] words = br.readLine().toCharArray();
		int src = 0, cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < DNA.length; i++) needed[i] = Integer.parseInt(st.nextToken());
		
		for(int des = 0; des < P - 1; des++) state[words[des]]++;
		for(int des = P - 1; des < S; des++) {
			state[words[des]]++;
			
			if(isValid(state)) cnt++;
			state[words[src]]--;
			src++;
		}
		
		System.out.print(cnt);
	}
}