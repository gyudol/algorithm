import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static String isBalanced(String line) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : line.toCharArray()) {
			switch(c) {
				case '[': case '(': stack.push(c); break;
				case ']': case ')': 
					if(stack.empty() || (c == ']' && stack.pop() != '[')
							|| (c == ')' && stack.pop() != '(')) return "no";
					break;
			}
		}
		
		return stack.empty() ? "yes" : "no";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		while(true) {
			String line = br.readLine();
			
			if(line.equals(".")) break;
			
			result.append(isBalanced(line)).append('\n');
		}
		
		System.out.print(result);
	}
}