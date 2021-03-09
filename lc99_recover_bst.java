/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode last = null;
    private TreeNode prev = null;
    
    
    public void recoverTree(TreeNode root) {
        dfs(root);    
        if (first != null && last != null) {
            swap(first, last);
        }
        else if (first != null && middle != null) {
            swap(first, middle);
        }
    }
    
    private void swap(TreeNode first, TreeNode last) {
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        //do inorder traverse;
        dfs(root.left);
        
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            }
            last = root;
        }
        prev = root;
        
        dfs(root.right);
    }
}
