class Solution {
    final int MODULUS = 1_000_000_007;
    final int[][] DIRECTIONS = {{0, 1}, {1, 0}};
    
    int[][] routes;
    
    int countRoutes(int row, int col, boolean[][] isPuddle) {
        if (row < 1 || col < 1 || isPuddle[row][col]) return 0;
        if (routes[row][col] != 0) return routes[row][col];
        
        return routes[row][col] = (countRoutes(row - 1, col, isPuddle) +
                countRoutes(row, col - 1, isPuddle)) % MODULUS;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        routes = new int[n + 1][m + 1]; 
        
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        
        routes[1][1] = 1;
        return countRoutes(n, m, isPuddle);
    }
}