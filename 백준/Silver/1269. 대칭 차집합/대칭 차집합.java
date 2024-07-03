import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aSize = Integer.parseInt(st.nextToken()), bSize = Integer.parseInt(st.nextToken());
		int isCnt = 0;	// intersectionCount
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < aSize; i++) set.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < bSize; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) isCnt++;
		}
		
		System.out.print(aSize + bSize - 2 * isCnt);
	}
}