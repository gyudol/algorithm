class Solution {
    Count compress(int[][] arr, int srcRow, int srcCol, int offset) {
        int s = arr[srcRow][srcCol];
        
        for (int row = srcRow; row < srcRow + offset; row++) {
            for (int col = srcCol; col < srcCol + offset; col++) {
                if (arr[row][col] != s) {
                    int half = offset / 2;
                    
                    return compress(arr, srcRow, srcCol, half)
                        .add(compress(arr, srcRow, srcCol + half, half))
                        .add(compress(arr, srcRow + half, srcCol, half))
                        .add(compress(arr, srcRow + half, srcCol + half, half));
                }
            }
        }
        
        return s == 0 ? new Count(1, 0) : new Count(0, 1);
    }
    
    public int[] solution(int[][] arr) {
        Count count = compress(arr, 0, 0, arr.length);
        return new int[] {count.zero, count.one};
    }
    
    class Count {
        int zero, one;
        
        Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }
}