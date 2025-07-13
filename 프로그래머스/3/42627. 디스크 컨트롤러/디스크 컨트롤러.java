import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> readyQ = new PriorityQueue<>();
        List<Job> waitingList = new ArrayList<>();
        
        for (int i = 0; i < jobs.length; i++) {
            waitingList.add(new Job(i, jobs[i][0], jobs[i][1]));    
        }
        
        // Comparator 우선
        waitingList.sort((j1, j2) -> Integer.compare(j1.start, j2.start));
        
        int cur = 0, total = 0, idx = 0;
        int waitingSize = waitingList.size();
        
        while (!readyQ.isEmpty() || idx < waitingSize) {
            while (idx < waitingSize && cur >= waitingList.get(idx).start) {
                readyQ.offer(waitingList.get(idx++));
            }
            
            if (readyQ.isEmpty()) {
                cur = waitingList.get(idx).start;
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