class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited,
                    List<Integer> permutation,
                    List<List<Integer>> res) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, res);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
        
    }
}
