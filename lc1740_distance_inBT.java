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
    public int findDistance(TreeNode root, int p, int q) {
        //find LCA first and then caculate the distance;
        TreeNode parent = findLCA(root, p, q);
        
        int distp = calDist(parent, p, 0);
        int distq = calDist(parent, q, 0);
        
        return distp + distq;
    }
    
    private TreeNode findLCA(TreeNode root, int p, int q){
        if (root == null) {
            return null;
        }
        
        if (root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        //p and q can equal;
        return left == null ? right : left;
    }
    
    private int calDist(TreeNode parent, int childVal, int dist) {
        if (parent == null) {
            return 0;
        }
        
        if (parent.val == childVal) {
            return dist;
        }
        
        int left = calDist(parent.left, childVal, dist + 1);
        int right = calDist(parent.right, childVal, dist + 1);
        
        return Math.max(left, right);
    }
}
