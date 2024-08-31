import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] DIR = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	private static int n;
	
	private static class Coord {
		private int row;
		private int col;
		
		private Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private static boolean promising(Coord king, Coord queen) {
		if(king.row == queen.row || king.col == queen.col
				|| Math.abs(king.row - queen.row) == Math.abs(king.col - queen.col)) return false;
		
		return true;
	}
	
	private static String playChess(Coord king, Coord[] queens) {
		boolean canBeAttacked = false;
		
		for(Coord queen : queens) {
			if(!promising(king, queen)) {
				canBeAttacked = true;
				break;
			}
		}
		
		for(int[] d : DIR) {
			int curRow = king.row + d[0];
			int curCol = king.col + d[1];
			boolean promising = false;
			
			if(curRow < 1 || curRow > n || curCol < 1 || curCol > n) continue;
			
			for(Coord queen : queens) {
				if(!promising(new Coord(curRow, curCol), queen)) {
					promising = false;
					break;
				}
				else promising = true;
			}
			
			if(promising) return canBeAttacked ? "CHECK" : "NONE";
		}
		
		return canBeAttacked ? "CHECKMATE" : "STALEMATE";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Coord king = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Coord[] queens = new Coord[k];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			queens[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(playChess(king, queens));
	}
}