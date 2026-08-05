class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length &&
                        col >= 0 && col < grid[0].length &&
                        grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
        // Queue<int[]> q=new ArrayDeque<>();
        // int fresh=0,minTime=0;
        // int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         if(grid[i][j]==1){
        //             fresh++;
        //         }
        //         if(grid[i][j]==2){
        //         q.add(new int[]{i,j});
        //         }
        //     }
        // }
        // while(fresh>0 && !q.isEmpty()){
        //     for(int i=0;i<q.size();i++){
        //         int[] cur=q.poll();
        //         for(int[] d:dir){
        //             int r=cur[0]+d[0];
        //             int c=cur[1]+d[1];
        //             if(r>=0 && r<grid.length && c>=0
        //             && c<grid[0].length && grid[r][c]==1){
        //                 grid[r][c]=2;
        //                 q.add(new int[]{r,c});
        //                 fresh--;
        //             }
        //         }
        //     }
        //     minTime++;
        // }
        // return fresh==0?minTime:-1;
    //}
//}
