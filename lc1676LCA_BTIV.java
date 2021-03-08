/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for (TreeNode t : nodes) {
            set.add(t.val);
        }
        
        return dfs(root, set);
    }
    
    private TreeNode dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root.val)) {
            return root;
        }
        
        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        else if (left == null) {
            return right;
        }
        else {
            return left;
        }
    }
}
