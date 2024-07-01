import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String [][] members = new String [n][2];
		
		for(int i = 0; i < n; i++) members[i] = br.readLine().split(" ");
		
		Arrays.sort(members, new Comparator<String []>() {
			@Override
			public int compare(String [] s1, String [] s2) {
				int age1 = Integer.parseInt(s1[0]),
						age2 = Integer.parseInt(s2[0]);
				
				return Integer.compare(age1, age2);
			}
		});
		
		for(String [] m : members) 
			result.append(m[0]).append(' ').append(m[1]).append('\n');
		
		System.out.print(result);
	}
}