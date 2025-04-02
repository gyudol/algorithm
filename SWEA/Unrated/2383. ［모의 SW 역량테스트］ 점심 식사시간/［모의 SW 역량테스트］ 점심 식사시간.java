import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	static final int LIMIT = 3;
	
	static class Axis {
		int row, col;
		
		Axis(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static class Stair extends Axis {
		int height;
		
		Stair(int row, int col, int height) {
			super(row, col);
			this.height = height;
		}
	}
	
	static int N;
	static int minCost;
	static int[][] room;
	static ArrayList<Axis> people;
	static Stair stairA, stairB;
	
	static int downStairs(boolean isStairA, boolean[] selectedA) {
		int curTime = 0;
		PriorityQueue<Integer> waitQ = new PriorityQueue<>();
		Queue<Integer> stairQ = new ArrayDeque<>();
		Stair stair = isStairA ? stairA : stairB;
		
		for (int i = 0; i < selectedA.length; i++) {
			if (isStairA != selectedA[i]) continue;
			
			Axis person = people.get(i);
			waitQ.offer(Math.abs(stair.row - person.row) + Math.abs(stair.col - person.col));
		}
		
		while (!waitQ.isEmpty()) {
			while (!stairQ.isEmpty() && stairQ.peek() == curTime) stairQ.poll();
			
			while (!waitQ.isEmpty() && waitQ.peek() <= curTime && stairQ.size() < LIMIT) {
				int arrTime = waitQ.poll();
				
				if (arrTime < curTime) stairQ.offer(curTime + stair.height);
				else stairQ.offer(curTime + stair.height + 1);
			}
			
			curTime++;
		}
		
		while (!stairQ.isEmpty()) curTime = stairQ.poll();
		
		return curTime;
	}
	
	static void subset(int src, boolean[] selectedA) {
		minCost = Math.min(Math.max(downStairs(true, selectedA), 
				downStairs(false, selectedA)), minCost);
		
		for (int i = src; i < selectedA.length; i++) {
			selectedA[i] = true;
			subset(i + 1, selectedA);
			selectedA[i] = false;
		}
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
			minCost = Integer.MAX_VALUE;
			room = new int[N][N];
			people = new ArrayList<>();
			boolean stairFlag = true;
			
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					room[row][col] = readInt();
					
					if (room[row][col] == 1) people.add(new Axis(row, col));
					else if (room[row][col] > 1) {
						if (stairFlag) stairA = new Stair(row, col, room[row][col]);
						else stairB = new Stair(row, col, room[row][col]);
						
						stairFlag = !stairFlag;
					}
				}
			}
			
			subset(0, new boolean[people.size()]);
			result.append('#').append(tc).append(' ').append(minCost).append('\n');
		}
		
		System.out.print(result);
	}
}