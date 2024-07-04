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
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(Integer.parseInt(st.nextToken())) {
				case 1: deque.addFirst(Integer.parseInt(st.nextToken())); break;
				case 2: deque.addLast(Integer.parseInt(st.nextToken())); break;
				case 3: result.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n'); break;
				case 4:	result.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n'); break;
				case 5: result.append(deque.size()).append('\n'); break;
				case 6: result.append(deque.isEmpty() ? 1 : 0).append('\n'); break;
				case 7: result.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n'); break;
				case 8: result.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n'); break;
			}
		}
		
		System.out.print(result);
	}
}