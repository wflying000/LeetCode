package dfs;

public class LC695 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            res += dfs(grid, nx, ny);
        }
        return res;
    }
}
