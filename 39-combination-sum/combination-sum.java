class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        totalCombinations(candidates, new ArrayList<Integer>(), ans, target, 0);
        return ans;
    }

    private void totalCombinations(int[] candidates, List<Integer>set, List<List<Integer>> result, int target, int n){
        if(n==candidates.length || target<0)
        return;

        if(target==0){
            result.add(new ArrayList<>(set));
            return;
        }

        set.add(candidates[n]);
        totalCombinations(candidates, set, result, target-candidates[n], n);
        set.remove(set.size()-1);
        totalCombinations(candidates, set, result, target, n+1);
    }
}