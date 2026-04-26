class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count=0;
        int prevend=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            //means overlaps
            //keep the min one removing the one with bigger end
            if(start<prevend){
                count++;
                prevend=Math.min(prevend,end);
                
            }
            else{
                //update the prevend pointer to end
                prevend=end;
                
            }
        }
        return count;
    }
}
