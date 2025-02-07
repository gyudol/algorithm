class Solution {
    private static final int[][] KEYPAD = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, 
                                           {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    private StringBuilder result = new StringBuilder();
    private Hand left, right;
    
    private class Hand {
        int row;
        int col;
        boolean isLeft;
        
        public Hand(int row, int col, boolean isLeft) {
            this.row = row;
            this.col = col;
            this.isLeft = isLeft;
        }
    }
    
    private int distance(int num, Hand hand) {
        return Math.abs(hand.row - KEYPAD[num][0]) + Math.abs(hand.col - KEYPAD[num][1]);
    }
    
    private void move(int num, boolean isLeftHanded, Hand left, Hand right) {
        int leftDist = distance(num, left), rightDist = distance(num, right);
        
        if(num % 3 == 1 || ((num % 3 == 2 || num == 0) && 
                            (leftDist < rightDist || (leftDist == rightDist && isLeftHanded)))) {
            result.append('L'); 
            left.row = KEYPAD[num][0];  left.col = KEYPAD[num][1];
        }
        else {
            result.append('R'); 
            right.row = KEYPAD[num][0];  right.col = KEYPAD[num][1];
        }
    }
    
    public String solution(int[] numbers, String hand) {
        Hand left = new Hand(3, 0, true), right = new Hand(3, 2, false);
        
        for(int number : numbers) move(number, hand.equals("left"), left, right);
        
        return result.toString();
    }
}