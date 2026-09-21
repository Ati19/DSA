class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int[] ans=new int[2];
        ans[0]=binarySearch(nums,target,true);
        ans[1]=binarySearch(nums,target,false);
        return ans;
    }
    private static int binarySearch(int[] nums,int target,
    boolean left){
        int low=0,high=nums.length-1,i=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                 i=mid;
                if(left){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return i;
    }
    
}