import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static int precedence(char c) {
		switch(c) {
			case '*': case '/': return 2;
			case '+': case '-': return 1;
			default: return 0;	// '('
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String expr = br.readLine();
		
		for(char c : expr.toCharArray()) {
			switch(c) {
				case '(': stack.push(c); break;
				case ')': 
					while(!stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());
					stack.pop(); break;		// '(' pop
				case '+': case '-': case'*': case '/':
					while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c))
						result.append(stack.pop());
					stack.push(c); break;
				default: result.append(c); break;	// operands ...
			}
		}
		
		while(!stack.isEmpty()) result.append(stack.pop());
		
		System.out.print(result);
	}
}