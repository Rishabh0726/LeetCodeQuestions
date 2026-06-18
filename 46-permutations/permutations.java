class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        getAllPermutation(nums, ans, 0);
        return ans;
    }

    private void getAllPermutation(int[] nums, List<List<Integer>> ans, int index){
        if(index==nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int num : nums){
            curr.add(num);
            }
            ans.add(curr);
            return;
        }

        for(int i=index; i<nums.length; i++){
            swap(nums, index, i);
            getAllPermutation(nums, ans, index+1);
            swap(nums, index, i);
        }
    }

    private void swap(int[]nums, int index1, int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}