class Solution {
    public int[] solution(String s) {
        int loop = 0, zeroCnt = 0;
        
        while (!s.equals("1")) {
            String replaced = s.replace("0", "");
            
            zeroCnt += s.length() - replaced.length();
            s = Integer.toString(replaced.length(), 2);
            loop++;
        }
        
        return new int[] {loop, zeroCnt};
    }
}