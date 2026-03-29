class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int minimum=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<minimum){
                minimum=nums[mid];
            }
            if(nums[start]<=nums[mid]){
                minimum=Math.min(minimum, nums[start]);
                start=mid+1;
            }
            else{
                minimum=Math.min(minimum, nums[mid]);
                end=mid-1;
            }
        }
        return minimum;
    }
}