import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    Point getIntersection(long A, long B, long E, long C, long D, long F) {
        long divisor = A * D - B * C,
            numeratorX = B * F - E * D, numeratorY = E * C - A * F;
        
        if (divisor == 0 || numeratorX % divisor != 0 ||
            numeratorY % divisor != 0) return null;
        
        return new Point(numeratorX / divisor, numeratorY / divisor);
    }
    
    public String[] solution(int[][] lines) {
        List<Point> meets = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                Point intersection = 
                    getIntersection(lines[i][0], lines[i][1], lines[i][2],
                                    lines[j][0], lines[j][1], lines[j][2]);
                
                if (intersection == null) continue;
                meets.add(intersection);
            }
        }
        
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, 
            maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        
        for (Point point : meets) {
            minX = (int) Math.min(point.x, minX);
            minY = (int) Math.min(point.y, minY);
            maxX = (int) Math.max(point.x, maxX);
            maxY = (int) Math.max(point.y, maxY);
        }
        
        char[][] board = 
            new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        for (Point point : meets) {
            board[(int) (maxY - point.y)][(int) (point.x - minX)] = '*';
        }
        
        return Arrays.stream(board)
                .map(String::new)
                .toArray(String[]::new);
    }
    
    class Point {
        long x, y;
        
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}