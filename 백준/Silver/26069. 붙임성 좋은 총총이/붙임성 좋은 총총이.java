import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> rbDance = new HashSet<>();
		rbDance.add("ChongChong");
		
		for(int i = 0; i < N; i++) {
			String [] names = br.readLine().split(" ");
			
			if(rbDance.contains(names[0])) rbDance.add(names[1]);
			else if(rbDance.contains(names[1])) rbDance.add(names[0]);
		}
		
		System.out.print(rbDance.size());
	}
}