class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int prev1=0;
        int prev2=0;
        for(int num:nums){
            int temp=prev1;
            prev1=Math.max(prev1,prev2+num);
            prev2=temp;
        }
        return prev1;
        // int[] t=new int[n+1];
        // t[0]=0;
        // t[1]=nums[0];
        // for(int i=1;i<n;i++){
        //     int val=nums[i];
        //     t[i+1]=Math.max(t[i-1]+val,t[i]);
        // }
        // return t[n];
    }
    // public static int util(int[] nums,int n){
    //     if(n < 0) return 0;
    //     if(n == 0) return nums[0];
    //     return Math.max(util(nums,n-2)+nums[n],util(nums,n-1));
    // }
}