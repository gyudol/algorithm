import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Solution {
    static final String[][] precedences = {"+-*".split(""), "+*-".split(""), "-+*".split(""),
                                        "-*+".split(""), "*+-".split(""), "*-+".split("")}; 
    
    long calculate(String op, long lhs, long rhs) {
        switch (op) {
            case "+": return lhs + rhs;
            case "-": return lhs - rhs;
            case "*": return lhs * rhs;
            default: return 0;
        }
    }
    
    long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1)),
                        rhs = Long.parseLong(tokens.get(i + 1)),
                        result = calculate(op, lhs, rhs);
                    
                    // 현재 위치 기준으로 연산자 제거
                    tokens.subList(i - 1, i + 2).clear();
                    tokens.add(i - 1, Long.toString(result));
                    i -= 2;
                }
            }
        }
        
        return Math.abs(Long.parseLong(tokens.get(0)));
    }
    
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long max = 0;
        
        for (String[] precedence : precedences) {
            max = Math.max(calculate(new ArrayList<>(tokens), precedence), max);
        }
        
        return max;
    }
}