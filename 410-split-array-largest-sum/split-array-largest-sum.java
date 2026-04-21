class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int n : nums){
            low=Math.max(low, n);
            high+=n;
        }
        int ans=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isSplited(nums, mid, k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isSplited(int[] nums, int part, int k){
        int subArrays=1;
        int partition=0;
        for(int i=0; i<nums.length; i++){
            if(partition+nums[i]<=part){
                partition+=nums[i];
            }else{
                subArrays++;
                partition=nums[i];
            }
            if(subArrays>k)
            return false;
        }
        return true;
    }
}