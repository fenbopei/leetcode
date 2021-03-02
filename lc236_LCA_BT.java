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
    private TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        traverse(root, p, q);
        return ans;*/
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);
        map.put(root, null);
        
        //iterate until find both p and q;
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode cur = stack.pop();
            
            if (cur.left != null) {
                stack.push(cur.left);
                map.put(cur.left, cur);
            }
            
            if (cur.right != null) {
                stack.push(cur.right);
                map.put(cur.right, cur);
            }
        }
        
        // find all ancester of p or q, they are their ancestor, too;
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        
        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        
        return q;
    }
    
    /*
    private boolean traverse(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return false;
        }
        
        int left = traverse(cur.left, p, q)? 1 : 0;
        int right = traverse(cur.right, p, q) ? 1 : 0;
        
        int mid = (cur == p || cur == q) ? 1 : 0;
        if (left + mid + right >= 2) {
            ans = cur;
        }
        
        return (mid + left + right) > 0;
    }*/
}
