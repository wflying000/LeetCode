import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC827 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int[][] tag = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1;
                    int s = dfs(grid, tag, i, j, t);
                    map.put(t, s);
                    res = Math.max(res, s);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int z = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (valid(x, y, n) && tag[x][y] != 0 && !set.contains(tag[x][y])) {
                            z += map.get(tag[x][y]);
                            set.add(tag[x][y]);
                        }
                    }
                    res = Math.max(res, z);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int[][] tag, int x, int y, int t) {
        int n = grid.length;
        int res = 1;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (valid(nx, ny, n) && tag[nx][ny] == 0 && grid[nx][ny] == 1) {
                res += dfs(grid, tag, nx, ny, t);
            }
        }
        return res;
    }

    private boolean valid(int x, int y, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}
