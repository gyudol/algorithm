import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 3;
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList<>();
		
		for(int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			
			if(xList.contains(x)) xList.remove(xList.get(0) == x ? 0 : 1);
			else xList.add(x);
			if(yList.contains(y)) yList.remove(yList.get(0) == y ? 0 : 1);
			else yList.add(y);
		}
		
		result.append(xList.get(0)).append(' ').append(yList.get(0));
		
		System.out.print(result);
	}
}