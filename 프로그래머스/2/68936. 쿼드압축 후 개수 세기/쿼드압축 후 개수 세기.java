class Solution {
    Square compress(int[][] arr, int srcRow, int srcCol, int offset) {
        int s = arr[srcRow][srcCol];
        
        for (int row = srcRow; row < srcRow + offset; row++) {
            for (int col = srcCol; col < srcCol + offset; col++) {
                if (arr[row][col] != s) {
                    int half = offset / 2;
                    Square square = new Square();
                    
                    for (int r = srcRow; r < srcRow + offset; r += half) {
                        for (int c = srcCol; c < srcCol + offset; c += half) {
                            square.add(compress(arr, r, c, half));
                        }
                    }
                        
                    return square;
                }
            }
        }
        
        return new Square(s);
    }
    
    public int[] solution(int[][] arr) {
        Square square = compress(arr, 0, 0, arr.length);
        return new int[] {square.zeroCnt, square.oneCnt};
    }
    
    class Square {
        int zeroCnt, oneCnt;
        
        Square() {}
        
        Square(int num) {
            if (num == 0) this.zeroCnt = 1;
            else this.oneCnt = 1;
        }
        
        void add(Square other) {
            this.zeroCnt += other.zeroCnt;
            this.oneCnt += other.oneCnt;
        }
    }
}