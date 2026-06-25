// Last updated: 6/25/2026, 8:38:50 AM
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> treeS = new Stack<>();
        if(root == null) return traversal;
        treeS.push(root);
        while(!treeS.isEmpty()){
            TreeNode curr = treeS.pop();
            traversal.add(curr.val);
            if(curr.right != null) {
                treeS.push(curr.right);
            } 
            if(curr.left != null) {
                treeS.push(curr.left);
            }
        }
        return traversal;
    }
}