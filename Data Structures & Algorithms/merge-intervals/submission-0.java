class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            //this is for prev's end so 1
            int lastend=list.get(list.size()- 1)[1];
            if(start<=lastend){
                list.get(list.size() - 1)[1]=Math.max(lastend,end);
            }
            //else add. it as it is 
            else{
                list.add(new int[] {start,end});
            }

        }
        int[][] res=new int[list.size()][2];
        for(int j=0;j<list.size();j++){
            res[j]=list.get(j);
        }
        return res;
    }
}
