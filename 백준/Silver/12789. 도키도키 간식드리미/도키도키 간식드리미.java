import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static String canReceive(Queue<Integer> line) {
		Stack<Integer> wait = new Stack<>();
		int turn = 1;
		
		while(!line.isEmpty()) {
			wait.push(line.poll());
			
			while(!wait.empty() && wait.peek() == turn) {
				wait.pop();
				turn++;
			}
		}
		
		return wait.empty() ? "Nice" : "Sad";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> line = new LinkedList<>();
		
		for(int i = 0; i < n; i++) line.offer(Integer.parseInt(st.nextToken()));
		
		System.out.print(canReceive(line));
	}
}