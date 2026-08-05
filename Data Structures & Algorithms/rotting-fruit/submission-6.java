class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new ArrayDeque<>();
        int fresh=0,minTime=0;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                q.add(new int[]{i,j});
                }
            }
        }
        while(fresh>0 && !q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                int[] cur=q.poll();
                for(int[] d:dir){
                    int r=cur[0]+d[0];
                    int c=cur[1]+d[1];
                    if(r>=0 && r<grid.length && c>=0
                    && c<grid[0].length && grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            minTime++;
        }
        return fresh==0?minTime:-1;
    }
}
