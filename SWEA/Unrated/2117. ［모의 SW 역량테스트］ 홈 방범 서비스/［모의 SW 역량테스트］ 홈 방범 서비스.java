import java.util.ArrayList;
import java.util.List;

class Solution {
	static int N, M;
	static List<House> houses;
	
	static int getMaxRevenue(int midRow, int midCol) {
		int max = 0;
		int[] dist = new int[houses.size()];
		
		for (int i = 0; i < houses.size(); i++) {
			House h = houses.get(i);
			dist[i] = Math.abs(midRow - h.row) + Math.abs(midCol - h.col);
		}
		
		for (int k = 1; k <= N + 1; k++) {
			int cnt = 0;
			
			for (int d : dist) {
				if (d < k) cnt++;
			}
			
			if (cnt * M >= k * k + (k - 1) * (k - 1)) {
				max = Math.max(cnt, max);
			}
		}
		
		return max;
	}
	
	static int getMaxRevenue() {
		int max = 0;
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				max = Math.max(getMaxRevenue(row, col), max);
			}
		}
		
		return max;
	}
	
	static int readInt() throws Exception {
		int c, n = 0;
		
		while ((c = System.in.read()) <= 32);
		do {
			n = (n << 3) + (n << 1) + (c & 15);
		} while ((c = System.in.read()) >= 48);
		
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		final int T = readInt();
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			M = readInt();
			houses = new ArrayList<>();
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (readInt() == 1) {
						houses.add(new House(row, col));
					}
				}
			}
			
			result.append('#').append(tc).append(' ').append(getMaxRevenue()).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class House {
		int row, col;
		
		House(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}