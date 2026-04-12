class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,-1,1};
        int perimeter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //If BFS inside loop:→ always add !visited condition
                //first chekc if it is a land and then start the bfs from there 
                if(grid[i][j]==1 && !visited[i][j]){
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                    while(!queue.isEmpty()){
                        int[] cell=queue.poll();
                        int r=cell[0];
                        int c=cell[1];
                        for(int k=0;k<4;k++){
                            int nr=r+drow[k];
                            int nc=c+dcol[k];
                            if(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]==0){
                                perimeter++;
                            }
                            //normal bfs
                            else if(!visited[nr][nc] && grid[nr][nc]==1){
                                visited[nr][nc]=true;
                                queue.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}