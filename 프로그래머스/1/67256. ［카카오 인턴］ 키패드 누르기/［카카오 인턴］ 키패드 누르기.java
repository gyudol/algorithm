class Solution {
    private static final int[][] KEYPAD = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    private static StringBuilder result = new StringBuilder();
    private static int leftRow = 3, leftCol = 0, rightRow = 3, rightCol = 2;
    
    private static int dist(int number, boolean isLeft) {   // only middle number
        for(int row = 0; row < KEYPAD.length; row++) {
            if(number == KEYPAD[row][1]) {
                if(isLeft) return Math.abs(leftRow - row) + Math.abs(leftCol - 1);
                else return Math.abs(rightRow - row) + Math.abs(rightCol - 1);
            }
        }
        
        return -1;
    }
    
    private static void move(int number, boolean isLeft) {
        for(int row = 0; row < KEYPAD.length; row++) {
            for(int col = 0; col < KEYPAD[row].length; col++) {
                if(number == KEYPAD[row][col]) {
                    if(isLeft) {
                        leftRow = row;  leftCol = col;
                    }
                    else {
                        rightRow = row; rightCol = col;
                    }
                    return;
                }
            }
        }
    }
    
    private static void move(int number, String hand) {
        if(number == KEYPAD[0][0] || number == KEYPAD[1][0] || number == KEYPAD[2][0]) {
            result.append('L');
            move(number, true);
        }
        else if(number == KEYPAD[0][2] || number == KEYPAD[1][2] || number == KEYPAD[2][2]) {
            result.append('R');
            move(number, false);
        }
        else {
            int leftDist = dist(number, true), rightDist = dist(number, false);
            boolean isLeft = (leftDist < rightDist) || ((leftDist == rightDist) && hand.equals("left"));
            
            if(isLeft) {
                result.append('L');
                move(number, true);
            }
            else {
                result.append('R');
                move(number, false);
            }
        }
    }
    
    public String solution(int[] numbers, String hand) {
        for(int number : numbers) move(number, hand);
        
        return result.toString();
    }
}