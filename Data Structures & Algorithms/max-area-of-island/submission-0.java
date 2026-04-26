class Solution {
    int[] drow={-1,1,0,0};
    int[] dcol={0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
    
        int maxarea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area= bfs(grid,visited,i,j);
                    maxarea=Math.max(area,maxarea);
                }
            }
        }
        return maxarea;
    }
    private int bfs(int[][] grid,boolean[][] visited,int row,int col){
        int n=grid.length;
        int m=grid[0].length;
        int area=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {row,col});
        visited[row][col]=true;
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int r=cell[0];
            int c=cell[1];
            area++;
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc]==1 && !visited[nr][nc] ){
                        queue.offer(new int[]{nr,nc});
                        visited[nr][nc]=true;
                    }

            }
        }
        return area;
    }
}
