import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1},
                                {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    
    public int solution(int[] arrows) {
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex cur = new Vertex(0, 0);
        int cnt = 0;
        
        vertices.put(cur.coord, cur);
        
        for (int arrow : arrows) {
            // 각 방향마다 2번 이동 (대각선 교차점에서 생기는 방을 감지)
            for (int i = 0; i < 2; i++) {
                int nx = cur.x + DIRECTIONS[arrow][0],
                    ny = cur.y + DIRECTIONS[arrow][1];
                String coord = Vertex.getCoord(nx, ny);

                if (!vertices.containsKey(coord)) {
                    vertices.put(coord, new Vertex(nx, ny));
                } else if (!cur.connectedVertices.contains(coord)) {
                    cnt++;
                }

                Vertex next = vertices.get(coord);

                cur.connectedVertices.add(coord);
                next.connectedVertices.add(cur.coord);
                cur = next;
            }
        }
        
        return cnt;
    }
    
    static class Vertex {
        int x, y;
        String coord;
        Set<String> connectedVertices;
        
        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.coord = getCoord(x, y);
            this.connectedVertices = new HashSet<>();
        }
        
        static String getCoord(int x, int y) {
            return String.format("%d,%d", x, y);
        }
    }
}