class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites ){
            list.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
          if(indegree[i]==0){
             q.offer(i);
          }
       }
       int count=0;
       while(!q.isEmpty()){
         int curr=q.poll();
         count++;
         for(int nei: list.get(curr)){
            indegree[nei]--;
            if(indegree[nei]==0){
                q.offer(nei);
            }
         }
       }
        return count==numCourses;
    }
}
