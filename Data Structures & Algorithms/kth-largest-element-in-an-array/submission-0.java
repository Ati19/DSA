class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Min Heap- Time complexity - O(nlogk),O(k)
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k)
            pq.poll();
        }
        return pq.peek();
    }
}
