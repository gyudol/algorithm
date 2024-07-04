import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static String isValid(String ps) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : ps.toCharArray()) {
			if(c == '(') stack.push(c);
			else if(stack.empty()) return "NO";
			else stack.pop();
		}
		
		return stack.empty() ? "YES" : "NO";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) result.append(isValid(br.readLine())).append('\n');
		
		System.out.print(result);
	}
}