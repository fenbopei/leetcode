class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(new ArrayList<Integer>(), nums, 0, ans);
        return ans;
    }
    
    private void dfs(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> ans) {
        //add every node to results;
        ans.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(subset, nums, i + 1, ans);
            //backtracking here;
            subset.remove(subset.size() - 1);
        }
    }
}
