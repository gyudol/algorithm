import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> readyQ = new PriorityQueue<>();
        Deque<Job> waitQ = new ArrayDeque<>();
        
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1[0], j2[0]));
        for (int i = 0; i < jobs.length; i++) {
            waitQ.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        int cur = 0, total = 0;
        
        while (!readyQ.isEmpty() || !waitQ.isEmpty()) {
            while (!waitQ.isEmpty() && cur >= waitQ.peek().start) {
                readyQ.offer(waitQ.poll());
            }
            
            if (readyQ.isEmpty()) {
                cur = waitQ.peek().start;
                continue;
            }
            
            Job process = readyQ.poll();
            cur += process.duration;
            total += cur - process.start;
        }
        
        return total / jobs.length;
    }
    
    class Job implements Comparable<Job> {
        int no, start, duration;
        
        Job(int no, int start, int duration) {
            this.no = no;
            this.start = start;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Job o) {
            if (duration != o.duration) {
                return Integer.compare(duration, o.duration);
            }
            if (start != o.start) {
                return Integer.compare(start, o.start);
            }
            return Integer.compare(no, o.no);
        }
    }
}