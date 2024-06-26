import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int [][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static int M;
	private static int N;
	private static int [][] field;
	
	private static void needWorms(int row, int col) {
		field[row][col] = 0;
		
		for(int [] d : DIR) {
			int nextRow = row + d[0], nextCol = col + d[1];
			
			if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M ||
					field[nextRow][nextCol] == 0) continue;
			
			needWorms(nextRow, nextCol);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			field = new int [N][M];
			List<int []> cabbages = new ArrayList<>();
			int worms = 0;
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken()), row = Integer.parseInt(st.nextToken());
				
				field[row][col] = 1;
				cabbages.add(new int [] {row, col});
			}
			
			for(int [] c : cabbages) {
				int row = c[0], col = c[1];
				
				if(field[row][col] == 0) continue;
				
				worms++;
				needWorms(row, col);
			}
			
			result.append(worms).append('\n');
		}
		
		System.out.print(result);
	}
}