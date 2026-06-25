// Last updated: 6/25/2026, 8:39:24 AM
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
    public TreeNode constructMirror(TreeNode root){
        if(root == null) return null;
        TreeNode root1 = new TreeNode(root.val);
        root1.right = constructMirror(root.left);
        root1.left = constructMirror(root.right);
        return root1;
    }
    public boolean checkSymmetric(TreeNode root, TreeNode root1){
        if(root == null && root1 == null){
            return true;
        } else if(root != null && root1 != null){
            if(root.val == root1.val){
                return (checkSymmetric(root.left, root1.left) && 
                checkSymmetric(root.right, root1.right));
            }
            return false;
        } else {
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode root1 = constructMirror(root);
        return checkSymmetric(root, root1);
    }
}