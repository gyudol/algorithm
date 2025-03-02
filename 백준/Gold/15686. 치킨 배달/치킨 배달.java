import java.util.ArrayList;
import java.util.List;

class Main {
	static int N, M;
	static List<Axis> homes, stores;
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int chickenDist(int[] isSelected) {
		int sum = 0;
		
		for (Axis home : homes) {
			int min = Integer.MAX_VALUE;
			
			for (int i : isSelected) {
				Axis store = stores.get(i);
				min = Math.min(Math.abs(home.row - store.row)
						+ Math.abs(home.col - store.col), min);
			}
			
			sum += min;
		}
		
		return sum;
	}
	
	static int dfs(int src, int depth, int[] isSelected) {
		if (depth == M) return chickenDist(isSelected);
		int min = Integer.MAX_VALUE;
		
		for (int i = src; i < stores.size(); i++) {
			isSelected[depth] = i;
			min = Math.min(dfs(i + 1, depth + 1, isSelected), min);
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
		homes = new ArrayList<>();
		stores = new ArrayList<>();
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int info = readInt();
				
				if (info == 1) homes.add(new Axis(row, col));
				else if (info == 2) stores.add(new Axis(row, col));
			}
		}
		
		System.out.print(dfs(0, 0, new int[M]));
	}
}