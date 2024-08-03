import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<List<Edge>> edges; 
	private static int farthestNodeNum;
	private static int max;
	
	private static class Edge {
		public int des;
		public int cost;
		
		private Edge(int des, int cost) {
			this.des = des;
			this.cost = cost;
		}
	}
	
	private static void dfs(int src, int sum, boolean [] isVisited) {
		if(isVisited[src]) return;
		isVisited[src] = true;
		
		if(sum > max) {
			max = sum;
			farthestNodeNum = src;
		}
		
		for(Edge edge : edges.get(src))
			dfs(edge.des, sum + edge.cost, isVisited);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		edges = new ArrayList<>();
		farthestNodeNum = -1;
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= v; i++) edges.add(new ArrayList<>());
		
		for(int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			
			while(true) {
				int des = Integer.parseInt(st.nextToken());
				
				if(des == -1) break;
				
				edges.get(src).add(new Edge(des, Integer.parseInt(st.nextToken())));
			}
		}
		
		// 트리의 특성: 임의의 정점에서 최장 정점을 구하면 항상 가장 긴 edge의 정점 중 하나를 포함한다.
		dfs(1, 0, new boolean [v + 1]);
		max = Integer.MIN_VALUE;
		dfs(farthestNodeNum, 0, new boolean [v + 1]);
		
		System.out.print(max);
	}
}