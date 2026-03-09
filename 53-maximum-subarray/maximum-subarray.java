class Solution {
    public int maxSubArray(int[] nums) {
        int negative=Integer.MIN_VALUE;
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            currentSum=currentSum+nums[i];
            if(currentSum<0){
                currentSum=0;
            }
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
            negative=Math.max(negative, nums[i]);
        }
        if(maxSum==0){
            return negative;
        }
        else
        return maxSum;
    }
}