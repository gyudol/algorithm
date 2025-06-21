class Solution {
    public int[] solution(String s) {
        int loop = 0, zeroCnt = 0;
        
        while (!s.equals("1")) {
            String replaced = s.replaceAll("[0]", "");
            
            zeroCnt += s.length() - replaced.length();
            loop++;
            s = Integer.toString(replaced.length(), 2);
        }
        
        return new int[] {loop, zeroCnt};
    }
}