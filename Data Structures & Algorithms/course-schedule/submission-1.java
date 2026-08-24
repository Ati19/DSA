class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:prerequisites){
            adj.get(e[0]).add(e[1]);
           
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] recS=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(adj,vis,recS,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfs(List<List<Integer>> adj,
    boolean[] vis,boolean[] recS,int u){
        vis[u]=true;
        recS[u]=true;
        for(Integer neigh:adj.get(u)){
            if(!vis[neigh]){
                if(!dfs(adj,vis,recS,neigh))
                return false;
            }
            else if(recS[neigh]){
                return false;
            }
        }
        recS[u]=false;
        return true;
    }
}
