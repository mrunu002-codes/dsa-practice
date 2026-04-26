class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int count=0;
        for(int node=0;node<n;node++){
            if(!visited[node]){
                dfs(list,visited,node);
                count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> list,boolean[] visited,int node){
        visited[node]=true;
        for(int nei: list.get(node)){
            if(!visited[nei]){
                dfs(list,visited,nei);
            }
        }
    }
}
