class Solution {
  
    public int[] topKFrequent(int[] nums, int k) {
          int[] out=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
           map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
                (a,b)->{
                    return map.get(a)-map.get(b);
                });
       for(int n:map.keySet()){
        pq.add(n);
        if(pq.size()>k)
        pq.poll();
       }
        for(int i=0;i<k;i++){
            out[i]=pq.poll();
        }
        return out;
    }
}
