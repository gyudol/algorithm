import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int LEN = 100;
	private static final int [] DICE = {1, 2, 3, 4, 5, 6};
	private static int [] boardElements;
	private static boolean [] isVisited;
	
	private static class Board {
		public int value;
		public int cnt;
		
		private Board(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
	}
	
	private static int move(int src) {
		if(boardElements[src] == 0) return src;
		
		while(boardElements[src] != 0) {
			src = boardElements[src];
			
			if(isVisited[src]) return -1;
			isVisited[src] = true;
		}
		
		return src;
	}
	
	private static int bfs() {
		Queue<Board> q = new LinkedList<>();
		q.offer(new Board(1, 0));
		isVisited[1] = true;
		
		while(!q.isEmpty()) {
			Board board = q.poll();
			
			if(board.value == LEN) return board.cnt;
			
			for(int pip : DICE) {
				int des = board.value + pip;
				
				if(des < 1 || des > LEN || isVisited[des]) continue;
				isVisited[des] = true;
				
				des = move(des);
				if(des == -1) continue;
				
				q.offer(new Board(des, board.cnt + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		boardElements = new int [LEN + 1];
		isVisited = new boolean [LEN + 1];
		
		for(int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			boardElements[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(bfs());
	}
}