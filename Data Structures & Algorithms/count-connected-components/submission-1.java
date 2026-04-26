class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        //check the bfs
        for(int node=0;node<n;node++){
            if(!visited[node]){
                bfs(list,visited,node);
                count++;
            }
        }
        return count;
    }
    private void bfs(List<List<Integer>> list,boolean[] visited,int node){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(node);
        visited[node]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();

            for(int nei:list.get(curr)){
                if(!visited[nei]){
                    visited[nei]=true;
                    queue.offer(nei);
                }
            }
        }
    }
}
