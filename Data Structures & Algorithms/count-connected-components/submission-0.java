class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count =0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int u,List<List<Integer>> adj,
    boolean[] vis){
        vis[u]=true;
        for(int v:adj.get(u)){
            if(!vis[v])
            dfs(v,adj,vis);
        }
    }
}
