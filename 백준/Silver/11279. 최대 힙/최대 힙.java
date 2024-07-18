import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) result.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
			else pq.offer(x);
		}
		
		System.out.print(result);
	}
}