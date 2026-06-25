// Last updated: 6/25/2026, 8:38:37 AM
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
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
    }
    
    public int next() {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        if(!stack.isEmpty()){
            root = stack.pop();
            int res = root.val;
            root = root.right;
            return res;
        }
        return Integer.MIN_VALUE;
    }
    
    public boolean hasNext() {
        if(root != null || !stack.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */