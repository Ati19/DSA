class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> merged=new ArrayList<>();
        for(int[] interval:intervals){
            if(merged.isEmpty()|| merged.getLast()[1]<
            interval[0])
            merged.add(interval);
            // else if(merged.getLast()[1]>=interval[0]){
          else{
                merged.getLast()[0]=Math.min(
                    merged .getLast()[0],interval[0]
                );
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
            }
            // else{
            //     merged.add(interval);
            // }
        }
        return merged.toArray(new int[merged.size()][]);
        
    }
}
