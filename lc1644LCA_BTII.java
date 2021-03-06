class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p, q);
        if (ans == null) {
            return null;
        }
        
        return ans;
    }
    
    private boolean dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return false;
        }
        
        int left = dfs(cur.left, p, q) ? 1 : 0;
        int right = dfs(cur.right, p, q) ? 1 : 0;
        
        int mid = (cur == p) || (cur == q) ? 1 : 0;
        if (left + mid + right >= 2) {
            ans = cur;
        }
        
        return (mid + left + right) > 0;    
    }
}
