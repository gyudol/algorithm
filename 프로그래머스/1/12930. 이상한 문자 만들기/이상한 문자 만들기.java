class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        int idx = 0;
        
        for(String sp : s.split("")) {
            if(sp.equals(" ")) idx = -1;
            if(idx++ % 2 == 0) result.append(sp.toUpperCase());
            else result.append(sp.toLowerCase());
        }
        
        return result.toString();
    }
}