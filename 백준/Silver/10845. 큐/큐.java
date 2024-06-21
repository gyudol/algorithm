import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int back = -1;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "push": back = Integer.parseInt(st.nextToken()); q.offer(back); break;
				case "pop": result.append(q.isEmpty() ? -1 : q.poll()).append('\n'); break;
				case "size": result.append(q.size()).append('\n'); break;
				case "empty": result.append(q.isEmpty() ? 1 : 0).append('\n'); break;
				case "front": result.append(q.isEmpty() ? -1 : q.peek()).append('\n'); break;
				case "back": result.append(q.isEmpty() ? -1 : back).append('\n'); break;
			}
		}
		
		System.out.print(result);
	}
}