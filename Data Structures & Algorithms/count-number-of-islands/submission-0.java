class Solution {
    public int numIslands(char[][] grid) {
        int noOfIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    public static void dfs(char[][] grid,int r,int c){
        int[][] directions={{1,0},{-1,0},{0,-1},{0,1}};
        if(r<0 || c<0 ||r>=grid.length || c>=grid[0].length
        || grid[r][c]=='0')
        return;
        grid[r][c]='0';
        for(int[] d:directions){
            dfs(grid,r+d[0],c+d[1]);
        }

    }

}
