import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	private static String sortInside(String n) {
		return Arrays.stream(n.split("")).sorted((s1, s2) -> s2.compareTo(s1))
				.collect(Collectors.joining());
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		System.out.print(sortInside(n));
	}
}