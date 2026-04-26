class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,-1,1};
        //push all sources in the queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int i=0;i<4;i++){
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==Integer.MAX_VALUE){
                    // update distance
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new int[] {nr,nc});
                }
            }
        }
    }
}
