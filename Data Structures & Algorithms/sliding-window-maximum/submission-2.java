class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n==0||k<=0)return new int[0];
        int[] out=new int[n-k+1];
        int j=0;
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                out[j++]=nums[deque.peekFirst()];
            }
        }
        return out;
    }
}
