class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using Quick Select Pivot element
        //Time complexity - O(n), Space- O(1)
        k =nums.length-k;
        return quickSelect(nums,0,nums.length-1,k);
        //Min Heap- Time complexity - O(nlogk),O(k)
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // for(int num:nums){
        //     pq.add(num);
        //     if(pq.size()>k)
        //     pq.poll();
        // }
        // return pq.peek();
    }
    private int quickSelect(int[] nums,int left,int right,
    int k){
        int pivot=nums[right];
        int p=left;
        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                int temp=nums[p];
                nums[p]=nums[i];
                nums[i]=temp;
                p++;
            }
        }
        int temp=nums[p];
        nums[p]=nums[right];
        nums[right]=temp;

    if(p>k){
        return quickSelect(nums,left,p-1,k);
    }
    else if(p<k){
        return quickSelect(nums,p+1,right,k);
    }
    else{
        return nums[p];
    }
    }
}
