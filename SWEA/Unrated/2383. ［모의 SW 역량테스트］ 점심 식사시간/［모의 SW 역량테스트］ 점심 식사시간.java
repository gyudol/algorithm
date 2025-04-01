import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static final int LIMIT = 3;
    
    static class Axis {
        int row, col, len;
        
        Axis(int row, int col) {
        	this.row = row;
        	this.col = col;
        }
        
        Axis(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }
    
    static int N;
    static int minCost;
    static int[][] room;
    static ArrayList<Axis> people;
    static ArrayList<Axis> stairs;
    
    static int downStairs(PriorityQueue<Integer> waitQ, int stairLen) {
    	int curTime = 0;
    	Queue<Integer> stairQ = new ArrayDeque<>();
    	
    	while (!waitQ.isEmpty()) {
    		while (!stairQ.isEmpty() && stairQ.peek() <= curTime) stairQ.poll();
    		
    		while (!waitQ.isEmpty() && waitQ.peek() <= curTime && stairQ.size() < LIMIT) {
    			int estTime = waitQ.poll();
    			
    			if (estTime < curTime) stairQ.offer(curTime + stairLen);
    			else stairQ.offer(curTime + stairLen + 1);
    		}
    		
    		curTime++;
    	}
    	
		while (!stairQ.isEmpty()) curTime = stairQ.poll();
    	
    	return curTime;
    }
    
    static int getMinimumTime(boolean[] isStairA) {
        PriorityQueue<Integer> targetA = new PriorityQueue<>(),
        		targetB = new PriorityQueue<>();
        Axis stairA = stairs.get(0), stairB = stairs.get(1);
        
        for (int i = 0; i < people.size(); i++) {
        	Axis person = people.get(i);
        	
        	if (isStairA[i]) targetA.offer(Math.abs(stairA.row - person.row) + 
        			Math.abs(stairA.col - person.col));
        	else targetB.offer(Math.abs(stairB.row - person.row) + 
        			Math.abs(stairB.col - person.col));
        }
        
        return Math.max(downStairs(targetA, stairA.len), downStairs(targetB, stairB.len));
    }
    
    static void subset(int src, boolean[] isStairA) {
        minCost = Math.min(getMinimumTime(isStairA), minCost);
        
        for (int i = src; i < isStairA.length; i++) {
        	isStairA[i] = true;
        	subset(i + 1, isStairA);
        	isStairA[i] = false;
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
            stairs = new ArrayList<>();
            
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    room[row][col] = readInt();
                    
                    if (room[row][col] == 1) people.add(new Axis(row, col));
                    else if (room[row][col] > 1) stairs.add(new Axis(row, col, room[row][col]));
                }
            }
            
            subset(0, new boolean[people.size()]);
            result.append('#').append(tc).append(' ').append(minCost).append('\n');
        }
        
        System.out.print(result);
    }
}