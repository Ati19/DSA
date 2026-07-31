class Solution {
    public int maxSubArray(int[] nums) {
        //recursion
        return dfs(nums,0,false);
    }
    private static int dfs(int[] nums,int i,boolean flag){
        if(i==nums.length-1)
        return flag?Math.max(0,nums[i]):nums[i];
        if(flag){
            return Math.max(0,nums[i]+dfs(nums,i+1,true));
        }
        return Math.max(dfs(nums,i+1,false),nums[i]+dfs(nums,i+1,true));
    
    }
        //Using Kadane's algorithm
        //if cur_sum is <0 no point keeping it
        // int cur_sum=0,max_sum=nums[0];
        // for(int num:nums){
        //     if(cur_sum<0)
        //     cur_sum=0;

        //     cur_sum+=num;
        //     max_sum=Math.max(cur_sum,max_sum);
        // }
        // return max_sum;
        // if(nums.length==0) return 0;
        // int current_sum=nums[0],max_sum=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     current_sum=Math.max(current_sum+nums[i],nums[i]);
        //     max_sum=Math.max(current_sum,max_sum);
           
        // }
        // return max_sum;
    // }
}
