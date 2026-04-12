class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int row, int col ,char[][] grid, boolean[][] visited){
        Queue<int[]> queue=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        queue.add(new int[]{row,col});
        visited[row][col]=true;
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int r=cell[0];
            int c=cell[1];
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == '1' &&
                    !visited[nr][nc]){
                    visited[nr][nc]=true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
