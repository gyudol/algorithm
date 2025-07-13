import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(i, rawJobs[i][0], rawJobs[i][1]);
        }
        
        // Comparator 우선
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.start, j2.start));
        
        PriorityQueue<Job> readyQ = new PriorityQueue<>();
        Deque<Job> waitingQ = new ArrayDeque<>(Arrays.asList(jobs));
        
        int cur = 0, total = 0;
        
        while (!readyQ.isEmpty() || !waitingQ.isEmpty()) {
            while (!waitingQ.isEmpty() && cur >= waitingQ.peek().start) {
                readyQ.offer(waitingQ.poll());
            }
            
            if (readyQ.isEmpty()) {
                cur = waitingQ.peek().start;
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