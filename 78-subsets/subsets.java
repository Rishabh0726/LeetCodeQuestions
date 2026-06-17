class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        getAllSubsets(nums, new ArrayList<Integer>(), ans, 0);
        return ans;
    } 
    private void getAllSubsets(int[]nums,   List<Integer>subset, List<List<Integer>> result, int n){
        if(n==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[n]);
        getAllSubsets(nums, subset, result, n+1);

        subset.remove(subset.size()-1);
        getAllSubsets(nums, subset, result, n+1);


    }
}