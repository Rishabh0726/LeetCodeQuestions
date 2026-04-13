class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int p : piles){
            high=Math.max(high, p);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            long totalHours=time(piles, mid);
            if(totalHours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private long time(int[] nums, int hourlySpeed){
    long total = 0;

    for(int n : nums){
        total += (n + hourlySpeed - 1) / hourlySpeed;
    }

    return total;
}
}