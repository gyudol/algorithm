import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean [] isStack = new boolean [n];
		Deque<Integer> qStack = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) isStack[i] = (Integer.parseInt(st.nextToken()) == 1);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(isStack[i]) continue;
			
			qStack.offerLast(num);
		}
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			qStack.offerFirst(Integer.parseInt(st.nextToken()));
			result.append(qStack.pollLast()).append(' ');
		}
		
		System.out.print(result);
	}
}