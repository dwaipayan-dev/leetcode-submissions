// Last updated: 6/25/2026, 8:36:50 AM
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode move = root;
        if(root == null) return new TreeNode(val);
        while(move != null){
            if(val > move.val){
                if(move.right == null) {
                    move.right = new TreeNode(val);
                    return root;
                }
                move = move.right;
            } else {
                if(move.left == null) {
                    move.left = new TreeNode(val);
                    return root;
                }
                move = move.left;
            }
        }
        return root;
    }
}