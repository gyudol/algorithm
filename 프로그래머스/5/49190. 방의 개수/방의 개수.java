import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1},
                                {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    
    public int solution(int[] arrows) {
        Map<Vertex, Set<Vertex>> vertices = new HashMap<>();
        Vertex cur = new Vertex(0, 0);
        int cnt = 0;
        
        vertices.put(cur, new HashSet<>());
        
        for (int arrow : arrows) {
            // 각 방향마다 2번 이동 (대각선 교차점에서 생기는 방을 감지)
            for (int i = 0; i < 2; i++) {
                int nx = cur.x + DIRECTIONS[arrow][0],
                    ny = cur.y + DIRECTIONS[arrow][1];
                Vertex next = new Vertex(nx, ny);

                if (!vertices.containsKey(next)) {
                    vertices.put(next, new HashSet<>());
                } else if (!vertices.get(next).contains(cur)) {
                    cnt++;
                }

                vertices.get(cur).add(next);
                vertices.get(next).add(cur);
                cur = next;
            }
        }
        
        return cnt;
    }
    
    class Vertex {
        int x, y;
        
        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Vertex)) return false;
            Vertex v = (Vertex) o;
            
            return x == v.x && y == v.y;
        }
    }
}