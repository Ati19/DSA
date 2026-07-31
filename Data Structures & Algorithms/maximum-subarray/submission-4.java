class Solution {
    public int maxSubArray(int[] nums) {
        //Using Kadane's algorithm
        //if cur_sum is <0 no point keeping it
        int cur_sum=0,max_sum=nums[0];
        for(int num:nums){
            if(cur_sum<0)
            cur_sum=0;

            cur_sum+=num;
            max_sum=Math.max(cur_sum,max_sum);
        }
        return max_sum;
        // if(nums.length==0) return 0;
        // int current_sum=nums[0],max_sum=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     current_sum=Math.max(current_sum+nums[i],nums[i]);
        //     max_sum=Math.max(current_sum,max_sum);
           
        // }
        // return max_sum;
    }
}
