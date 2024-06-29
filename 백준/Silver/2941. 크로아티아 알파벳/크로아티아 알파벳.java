import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final String [] CROATIA = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		for(String croatia : CROATIA) {
			word = word.replace(croatia, "*");
		}
		
		System.out.print(word.length());
	}
}