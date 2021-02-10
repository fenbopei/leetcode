class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, new ArrayList<>(), visited, ans);
        return ans;
    }
    
    private void dfs(int[] nums, List<Integer> permutation, boolean[] visited, List<List<Integer>> ans) {
        if (permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, permutation, visited, ans);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
