import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "1": stack.push(Integer.parseInt(st.nextToken())); break;
				case "2": result.append(stack.empty() ? -1 : stack.pop()).append('\n'); break;
				case "3": result.append(stack.size()).append('\n'); break;
				case "4": result.append(stack.empty() ? 1 : 0).append('\n'); break;
				case "5": result.append(stack.empty() ? -1 : stack.peek()).append('\n'); break;
			}
		}
		
		System.out.print(result);
	}
}