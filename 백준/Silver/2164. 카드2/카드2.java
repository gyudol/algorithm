import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) cards.offer(i);
		
		while(cards.size() > 1) {
			cards.poll();
			cards.offer(cards.poll());
		}
		
		System.out.print(cards.poll());
	}
}