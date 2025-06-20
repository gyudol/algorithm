class Solution {
    int countTicketNumber(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }
        
        int cnt = 0, cur = numbers[depth];
        
        return cnt += countTicketNumber(depth + 1, sum - cur, numbers, target) +
            countTicketNumber(depth + 1, sum + cur, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        return countTicketNumber(0, 0, numbers, target);
    }
}