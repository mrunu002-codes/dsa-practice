class Solution {
    public void setZeroes(int[][] matrix) {
        //nikhil lohia
        //dry run spiral book
        int n=matrix.length;
        int m=matrix[0].length;
        boolean isRow=false;
        boolean isCol=false;
        //fill the outer rows and cols
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0) isRow=true;
                    if(j==0) isCol=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //fill inner rows and cols 
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //outer rows and cols leftover
        if(isRow){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(isCol){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    
        }
    }

