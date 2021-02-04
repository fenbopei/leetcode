class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        dfs(nums, 0 ,new ArrayList<>(), ans);
        return ans;
    }
    
    private void dfs (int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subset));
        //
        for (int i = startIndex; i < nums.length; i++) {
            //ignore the duplicate
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, ans);
            //backtracking
            subset.remove(subset.size() - 1);
        }
    }
}
