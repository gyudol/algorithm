import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int M = 6;
	
	private static int getArea(int[][] moves, int maxHeight, int maxWidth) {
		int rowDiff = -1, colDiff = -1;
		
		for(int i = 0; i < moves.length; i++) {
			if((moves[i][0] == 1 || moves[i][0] == 2) && maxWidth == moves[i][1]) 
				rowDiff = Math.abs(moves[(i - 1 + M) % M][1] - moves[(i + 1) % M][1]);
			if((moves[i][0] == 3 || moves[i][0] == 4) && maxHeight == moves[i][1]) 
				colDiff = Math.abs(moves[(i - 1 + M) % M][1] - moves[(i + 1) % M][1]);
		}
			
		return maxHeight * maxWidth - rowDiff * colDiff;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int K = Integer.parseInt(br.readLine());
		int[][] moves = new int[M][2];
		int maxHeight = 0, maxWidth = 0;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()), offset = Integer.parseInt(st.nextToken());
			
			moves[i][0] = d;	moves[i][1] = offset;
			if(d == 1 || d == 2) maxWidth = Math.max(offset, maxWidth);
			else maxHeight = Math.max(offset, maxHeight);
		}
		
		System.out.print(getArea(moves, maxHeight, maxWidth) * K);
	}
}