class Solution {
    public int trap(int[] height) {
        int total=0;
        int l=0;
        int r=height.length-1;
        int leftMax=0;
        int rightMax=0;
        while(l<r){
            leftMax=Math.max(leftMax, height[l]);
            rightMax=Math.max(rightMax, height[r]);
            if(leftMax<rightMax){
                total+=(leftMax-height[l]);
                l++;
            }else{
                total+=(rightMax-height[r]);
                r--;
            }
        }
        return total;
    }
}