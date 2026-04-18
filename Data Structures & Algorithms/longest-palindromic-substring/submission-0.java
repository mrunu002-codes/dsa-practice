class Solution {
    //refer the video of code story with mik
    public String longestPalindrome(String s) {
        int n=s.length();
        int sp=0;
        int maxlen=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=n-1; i >=0;i--){
            for(int j=i;j<n ; j++){
                if(s.charAt(i)==s.charAt(j) && ((j-i)<=2 || 
                dp[i+1][j-1])){
                    dp[i][j]=true;

                    if(maxlen< (j-i+1)){
                        sp=i;
                        maxlen=j-i+1;
                    }
                }
            }
        }
        return s.substring(sp,maxlen+sp);
    }
}
