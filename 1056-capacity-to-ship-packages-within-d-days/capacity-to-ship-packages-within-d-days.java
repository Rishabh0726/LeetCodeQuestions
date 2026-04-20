class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w : weights){
            low=Math.max(low, w);
            high=high+w;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int time=noOfDays(weights, mid);
            if(time>days){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    private int noOfDays(int[] weights, int capacity){
        int days=1;
        int temp=0;
        for(int w : weights){
            if(temp+w > capacity){
                days++;
                temp=w;
            }else{
                temp+=w;
            }
        }
        return days;
    }
}