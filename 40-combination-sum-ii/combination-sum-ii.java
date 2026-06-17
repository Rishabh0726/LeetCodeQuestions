class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        totalCombinations(candidates, new ArrayList<Integer>(), ans, target, 0);
        return ans;
    }
    private void totalCombinations(int[] candidates, List<Integer>set, List<List<Integer>> result, int target, int n){
        if(target==0){
            result.add(new ArrayList<>(set));
            return;
        }
        if(n==candidates.length || target<0)
        return;
        set.add(candidates[n]);
        totalCombinations(candidates, set, result, target-candidates[n], n+1);
        set.remove(set.size()-1);
        while(n + 1 < candidates.length && candidates[n] == candidates[n+1]){
            n++;
        }
        totalCombinations(candidates, set, result, target, n+1);
    }
}