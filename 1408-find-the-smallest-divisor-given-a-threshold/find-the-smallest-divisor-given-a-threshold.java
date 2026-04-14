class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int n:nums){
            high=Math.max(high, n);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isSmallest(nums, mid, threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isSmallest(int[]nums, int divisor, int threshold){
        int sum=0;
        for(int n: nums){
            sum+=(n+divisor-1)/divisor;
        }
        return threshold >= sum;
    }
}