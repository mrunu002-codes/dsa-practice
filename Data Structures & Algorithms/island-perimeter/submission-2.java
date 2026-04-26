class Solution {
   // Loop runs → finds first land → BFS → RETURN → END 
   //so just return bfs once only
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,1,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return bfs(grid,visited,i,j,drow,dcol);
                }
            }
        }
        return 0;
    }

    private int bfs(int[][]grid,boolean[][] visited,int row,int col,int[] drow, int[] dcol){
        int n=grid.length;
        int m=grid[0].length;
       // boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        int perimeter=0;
        q.offer(new int[] {row,col});
        visited[row][col]=true;
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 0) {
                    perimeter++;
                }
                else if(!visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return perimeter;
    }
}