class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                row.add(1);
                else
                row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
        // List<List<Integer>> ans=new ArrayList<>();
        // for(int i=0;i<numRouws;i++){
        //    List<Integer> row=new ArrayList<>();
        //    row.add(1);
        //    int val=1;
        //    for(int k=1;k<=i;k++){
        //     val=val*(n-k+1)/k;
        //     row.add(val);
        //    }
        //    res.add(row);
        // }
        // return res;
    }
}