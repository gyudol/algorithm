class Solution {
	static final int T = 10;
	static final int W = 100;
	
	static int N;
	static int[] boxes;
	
	static int getHeightDiffByFlattening() {
		for (int i = 0; i < N; i++) {
			BoxInfo boxInfo = new BoxInfo(boxes);
			
			if (boxInfo.max - boxInfo.min <= 1) return boxInfo.max - boxInfo.min;
			
			boxes[boxInfo.maxIdx]--;
			boxes[boxInfo.minIdx]++;
		}
		
		BoxInfo boxInfo = new BoxInfo(boxes);
		return boxInfo.max - boxInfo.min;
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
		StringBuilder result = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = readInt();
			boxes = new int[W];
			
			for (int i = 0; i < W; i++) {
				boxes[i] = readInt();
			}
			
			result.append('#').append(tc).append(' ')
				.append(getHeightDiffByFlattening()).append('\n');
		}
		
		System.out.print(result);
	}
	
	static class BoxInfo {
		int max = 0, min = 101, maxIdx = -1, minIdx = -1;
		
		BoxInfo(int[] boxes) {
			for (int i = 0; i < boxes.length; i++) {
				if (boxes[i] > max) {
					max = boxes[i];
					maxIdx = i;
				}
				if (boxes[i] < min) {
					min = boxes[i];
					minIdx = i;
				}
			}
		}
	}
}