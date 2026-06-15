class Solution {
     static class Pair{
        int key;
        int count;

        Pair(int key,int count){
            this.key=key;
            this.count=count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
          int[] out=new int[k];
        Map<Integer,Integer> map=new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else {
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
                (a,b)->{
                    if(b.count!=a.count)
                        return b.count-a.count;
                    return a.key-b.key;
                });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for(int i=0;i<k;i++){
            out[i]=pq.poll().key;
        }
        return out;
    }
}
