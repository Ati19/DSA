class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        //sort the elements 
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //if number greater than 0,all positive
            if(nums[i]>0)break;
            //skip duplicates;
            if(i>0 && nums[i]==nums[i-1])continue;
            int l=i+1,r=nums.length-1;
            //fix one number and find the others wit 2 pointers
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum>0)r--;
                else if(sum<0)l++;
                else{
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    //Skip duplicates
                    while(l<r && nums[l]==nums[l-1])
                    l++;
                }
            }
        }
        return ans;
    }
}
