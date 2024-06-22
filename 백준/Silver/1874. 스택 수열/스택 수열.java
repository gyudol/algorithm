import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		Set<Integer> isUsed = new HashSet<>();;
		Stack<Integer> stack = new Stack<>();
		int cur = 0;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(isUsed.contains(num)) {
				result.setLength(0);
				result.append("NO");
				break;
			}
			
			while(cur < num) {
				cur++;
				if(isUsed.contains(cur)) continue;
				
				stack.push(cur);
				result.append('+').append('\n');
			}
			
			while(!stack.empty() && stack.peek() >= num) {
				cur = stack.pop();
				isUsed.add(cur);
				result.append('-').append('\n');
			}
		}
		
		System.out.print(result);
	}
}