import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M;
	static int[][] city;
	static List<Axis> homes, stores;
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int chickenDist(boolean[] isSelected) {
		int sum = 0;
		
		for(Axis home : homes) {
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < stores.size(); i++) {
				if (!isSelected[i]) continue;
				min = Math.min(Math.abs(home.row - stores.get(i).row)
						+ Math.abs(home.col - stores.get(i).col), min);
			}
			
			sum += min;
		}
		
		return sum;
	}
	
	static int dfs(int src, int depth, boolean[] isSelected) {
		int min = Integer.MAX_VALUE;
		
		if (depth > M) return min;
		if(depth > 0) min = chickenDist(isSelected);
		
		for (int i = src; i < stores.size(); i++) {
			isSelected[i] = true;
			min = Math.min(dfs(i + 1, depth + 1, isSelected), min);
			isSelected[i] = false;
		}
		
		return min;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String [] args) throws Exception {
		N = readInt();	M = readInt();
		city = new int[N][N];
		homes = new ArrayList<>();
		stores = new ArrayList<>();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				city[row][col] = readInt();
				if (city[row][col] == 1) homes.add(new Axis(row, col));
				else if (city[row][col] == 2) stores.add(new Axis(row, col));
			}
		}
		
		System.out.print(dfs(0, 0, new boolean[stores.size()]));
	}
}