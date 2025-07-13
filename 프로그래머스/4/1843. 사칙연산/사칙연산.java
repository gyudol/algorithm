import java.util.Arrays;

class Solution {
    int[][] maxMem, minMem;
    
    int getMin(int start, int end, String[] arr) {
        if (minMem[start][end] != Integer.MAX_VALUE) return minMem[start][end];
        if (end - start == 1) return Integer.parseInt(arr[start]);
        
        int min = Integer.MAX_VALUE;
        
        for (int i = start + 1; i < end; i += 2) {
            int left = getMin(start, i, arr),
                right = arr[i].equals("+") ? getMin(i + 1, end, arr) 
                    : getMax(i + 1, end, arr);
            
            int value = arr[i].equals("+") ? left + right : left - right;
            min = Math.min(value, min);
        }
        
        return minMem[start][end] = min;
    }
    
    int getMax(int start, int end, String[] arr) {
        if (maxMem[start][end] != Integer.MIN_VALUE) return maxMem[start][end];
        if (end - start == 1) return Integer.parseInt(arr[start]);
        
        int max = Integer.MIN_VALUE;
        
        for (int i = start + 1; i < end; i += 2) {
            int left = getMax(start, i, arr),
                right = arr[i].equals("+") ? getMax(i + 1, end, arr)
                    : getMin(i + 1, end, arr);
                
            int value = arr[i].equals("+") ? left + right : left - right;
            max = Math.max(value, max);
        }
        
        return maxMem[start][end] = max;
    }
    
    public int solution(String arr[]) {
        maxMem = new int[arr.length][arr.length + 1];
        minMem = new int[arr.length][arr.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(maxMem[i], Integer.MIN_VALUE);
            Arrays.fill(minMem[i], Integer.MAX_VALUE);
        }
        
        return getMax(0, arr.length, arr);
    }
}