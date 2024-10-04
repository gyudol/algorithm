import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	
	private static int getNthLargest(PriorityQueue<Integer> pq) {
		for(int i = 0; i < N - 1; i++) pq.poll();
		
		return pq.poll();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(getNthLargest(pq));
	}
}