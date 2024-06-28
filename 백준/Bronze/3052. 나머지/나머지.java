import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static final int DIV = 42;
	private static final int LEN = 10;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < LEN; i++) {
			set.add(Integer.parseInt(br.readLine()) % DIV);
		}
		
		System.out.print(set.size());
	}
}