import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) pq.offer(Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(pq.peek() < num) {
					pq.poll();
					pq.offer(num);
				}
			}
		}
		
		System.out.print(pq.poll());
	}
}