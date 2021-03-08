class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        boolean res1 = search(q, p.val);
        boolean res2 = search(p, q.val);
        
        if (res1) {
            return q;
        }
        if (res2) {
            return p;
        }
        
        return lowestCommonAncestor(p.parent, q.parent);
    }
    
    private boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        
        if (root.val == val) {
            return true;
        }
        
        boolean inLeft = search(root.left,val);
        boolean inRight = search(root.right, val);
        
        return inLeft || inRight;
    }
}
