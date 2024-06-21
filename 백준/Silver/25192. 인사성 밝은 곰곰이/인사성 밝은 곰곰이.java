import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> usedGom = new HashSet<>();
		int gomgom = 0;
		
		for(int i = 0; i < N; i++) {
			String id = br.readLine();
			
			if(id.equals("ENTER")) {
				usedGom.clear();
				continue;
			}
			
			if(usedGom.contains(id)) continue;
			usedGom.add(id);
			gomgom++;
		}
		
		System.out.print(gomgom);
	}
}