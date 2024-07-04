import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) sum -= stack.pop();
			else sum += stack.push(num);
		}
		
		System.out.print(sum);
	}
}