import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "push": stack.push(Integer.parseInt(st.nextToken())); break;
				case "pop": result.append(stack.empty() ? -1 : stack.pop()).append('\n'); break;
				case "size": result.append(stack.size()).append('\n'); break;
				case "empty": result.append(stack.empty() ? 1 : 0).append('\n'); break;
				case "top": result.append(stack.empty() ? -1 : stack.peek()).append('\n'); break;
			}
		}
		
		System.out.print(result);
	}
}