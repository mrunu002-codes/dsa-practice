class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        for(int i=0;i< numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        int[] result=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            result[index]=node;
            index++;
            for(int nei:list.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return result;
    }
}
