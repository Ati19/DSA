class Solution {
    public int search(int[] nums, int target) {
         int l=0,h=nums.length-1;
         while(l<h){
            int m=l+(h-l)/2;
            if(nums[m]>nums[h]){
                l=m+1;
            }
            else{
                h=m;
            }
         }
         int left=binarySearch(nums,target,0,l-1);
         int right=binarySearch(nums,target,l,nums.length-1);
         if(left==right)
         return -1;
         else 
         return left==-1?right:left;
    }
    private static int binarySearch(int[] nums,int target,int l,int h){
        while(l<=h){
        int m=l+(h-l)/2;
        if(nums[m]==target){
            return m;
        }
        else if(nums[m]>target)
        h=m-1;
        else
        l=m+1;
        }
        return -1;
    }
}
