import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class Node {
		private Node parent;
		
		private Node root() {
			if(parent == null) return this;
			return parent = parent.root();
		}
		
		private boolean isConnected(Node other) {
			return root() == other.root();
		}
		
		private void merge(Node other) {
			if(isConnected(other)) return;
			other.root().parent = this;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[N + 1];
		
		for(int i = 0; i <= N; i++) nodes[i] = new Node();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			final int op = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()),
					b = Integer.parseInt(st.nextToken());
			
			if(op == 0) nodes[a].merge(nodes[b]);
			else result.append(nodes[a].isConnected(nodes[b]) ? "YES" : "NO").append('\n');
		}
		
		System.out.print(result);
	}
}