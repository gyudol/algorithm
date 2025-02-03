class Solution {
    public int[] solution(long n) {
        return new StringBuilder(Long.toString(n))
            .reverse().toString()
            .chars().boxed()
            .mapToInt(c -> c - '0').toArray();
    }
}