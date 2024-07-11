import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int MOD = 10000;
	private static final char [] CHARS = {'D', 'S', 'L', 'R'};
	
	private static class Dslr {
		public int value;
		public String orders;
		
		private Dslr(int value, String orders) {
			this.value = value;
			this.orders = orders;
		}
	}
	
	private static String bfs(int a, int b) {
		Queue<Dslr> q = new LinkedList<>();
		boolean [] isVisited = new boolean [MOD];
		q.offer(new Dslr(a, ""));
		isVisited[a] = true;
		
		while(!q.isEmpty()) {
			Dslr dslr = q.poll();
			int value = dslr.value;
			
			if(value == b) return dslr.orders;
			
			int [] orders = new int [CHARS.length]; // order DSLR
			orders[0] = value * 2 % MOD;
			orders[1] = (value + 9999) % MOD;
			orders[2] = value * 10 / MOD + value * 10 % MOD;
			orders[3] = value / 10 + value % 10 * 1000;
			
			for(int i = 0; i < orders.length; i++) {
				if(!isVisited[orders[i]]) {
					isVisited[orders[i]] = true;
					q.offer(new Dslr(orders[i], dslr.orders + CHARS[i]));
				}
			}
		}
		
		return "-1";
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			result.append(bfs(a, b)).append('\n');
		}
		
		System.out.print(result);
	}
}