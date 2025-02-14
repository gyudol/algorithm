import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	private static int N, M;
	private static int[][] VERTICES;
	
	private static class Axis {
		int row, col, type;
		
		public Axis(int type, int dist) {
			this.row = VERTICES[type][0] + dist * (type < 3 ? 0 : 1);
			this.col = VERTICES[type][1] + dist * (type < 3 ? 1 : 0);
			this.type = type;
		}
	}
	
	private static int getDist(Axis src, Axis[] stores) {
		final int round = (N + M) * 2;
		int sum = 0;
		
		for(Axis store : stores) {
			int curRow = store.row, curCol = store.col, type = store.type;
			int v = type % 2 == 1 ? type / 2 : type / 2 + 1, dist = 0;
			// type: {1, 2, 3, 4} => v: {0, 2, 1, 3}
			
			while(curRow != src.row || curCol != src.col) {
				int nextRow = curRow + DIR[v][0], nextCol = curCol + DIR[v][1];
				
				if(nextRow < 0 || nextRow > M || nextCol < 0 || nextCol > N) {
					v = (v + 1) % DIR.length;
					continue;
				}
				
				curRow = nextRow;	curCol = nextCol;	
				dist++;
			}
			
			sum += Math.min(dist, round - dist);
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		VERTICES = new int[][] {null, {0, 0}, {M, 0}, {0, 0}, {0, N}};
		
		final int K = Integer.parseInt(br.readLine());
		Axis[] stores = new Axis[K];
		Axis src;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			stores[i] = new Axis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		src = new Axis(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		System.out.print(getDist(src, stores));
	}
}