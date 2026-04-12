class Solution {

    int[][] grid;
    boolean[][] vis;
    int n, m;

    int[] drow = {0, 0, -1, 1};
    int[] dcol = {-1, 1, 0, 0};

    public int islandPerimeter(int[][] grid) {

        this.grid = grid;
        n = grid.length;
        m = grid[0].length;

        vis = new boolean[n][m];

        int perimeter = 0;

        // traverse grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    perimeter += dfs(i, j);
                }
            }
        }

        return perimeter;
    }

    private int dfs(int r, int c) {

        // 🔥 boundary → contributes to perimeter
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return 1;
        }

        if (vis[r][c]) return 0;

        vis[r][c] = true;

        int per = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + drow[i];
            int nc = c + dcol[i];

            per += dfs(nr, nc);
        }

        return per;
    }
}