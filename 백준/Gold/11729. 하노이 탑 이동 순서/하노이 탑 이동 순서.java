import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static void hanoi(List<int []> hanoi, int from, int to, int n) {
		if(n == 1) {
			hanoi.add(new int [] {from, to});
			return;
		}
		
		int empty = 6 - from - to;
		
		hanoi(hanoi, from, empty, n - 1);
		hanoi(hanoi, from, to, 1);
		hanoi(hanoi, empty, to, n - 1);
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int []> hanoi = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		
		hanoi(hanoi, 1, 3, N);
		
		result.append(hanoi.size()).append('\n');
		for(int [] proc : hanoi) result.append(proc[0]).append(' ').append(proc[1]).append('\n');
		
		System.out.print(result);
	}
}