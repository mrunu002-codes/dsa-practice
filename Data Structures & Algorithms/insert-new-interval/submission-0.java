class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        int i=0;
        while(i<n){
             // case 1: completely left (no overlap)
            if(intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
            }
              // case 2: completely right (no overlap)
            else if(intervals[i][0]> newInterval[1]){
                break;
            }
            // case 3: overlap → merge
            else{
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            i++;
        }
         // add merged interval
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i]);
            i++;
        }

         // convert to array
        int[][] ans=new int[list.size()][2];
        for(int j=0;j<list.size(); j++){
            ans[j]=list.get(j);
        }
     return ans;
    }
}
