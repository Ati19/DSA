class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:prerequisites){
            adj.get(e[0]).add(e[1]);
        }
        if(!possible(adj,numCourses)){
            return new int[]{};
        }
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[numCourses];
        boolean[] vis=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                dfs(adj,i,vis,stack);
            }
        }
        int i=numCourses-1;
        while(!stack.isEmpty()){
            ans[i--]=stack.pop();
        }
        return ans;
        
    }
    private static void dfs(List<List<Integer>> adj,
    int v,boolean[] vis,Stack<Integer> stack){
        vis[v]=true;
        for(Integer neighbor:adj.get(v)){
            if(!vis[neighbor])
            dfs(adj,neighbor,vis,stack);
        }
        stack.add(v);
    }
    private static boolean possible(
    List<List<Integer>> adj,int n){
        boolean[] vis=new boolean[n];
        boolean[] recS=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(!canVisit(adj,vis,recS,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean canVisit(List<List<Integer>> adj,
    boolean[] vis,boolean[] recS,int v){
        vis[v]=true;
        recS[v]=true;
        for(Integer neighbor:adj.get(v)){
            if(!vis[neighbor]){
                if(!canVisit(adj,vis,recS,neighbor))
                return false;
            }
            else if(recS[neighbor])
            return false;
        }
        recS[v]=false;
        return true;
    }
}
