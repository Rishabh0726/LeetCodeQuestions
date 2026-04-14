class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)
        return -1;
            int low=Integer.MAX_VALUE;
            int high=Integer.MIN_VALUE;
            for(int b : bloomDay){
                low=Math.min(low, b);
                high=Math.max(high, b);
            }
            int ans=0;
            while(low<=high){
                int mid= low+(high-low)/2;
                if(canMake(bloomDay, mid, m, k)){
                    ans=mid;
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            return ans;
    }
    private boolean canMake(int[]arr, int days, int m, int k){
        int bouquets=0;
        int consecitive=0;
        for(int a : arr){
            if(a<=days){
                consecitive=consecitive+1;
                if(consecitive==k){
                    bouquets++;
                    if(bouquets>=m){
                        return true;
                    }
                    consecitive=0;
                }
            } 
            else{
                consecitive=0;
            }
        }
        return bouquets>=m;
    }
}