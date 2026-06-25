// Last updated: 6/25/2026, 8:39:16 AM
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
    public boolean dfsUtils(TreeNode root, int targetSum, int parentSum){
        if(root == null){
            return false;
        }
        else{
            if(root.left == null && root.right == null){
                if(targetSum == parentSum + root.val) return true;
                return false;
            }
            if(dfsUtils(root.left, targetSum, parentSum + root.val)){
                return true;
            }
            if(dfsUtils(root.right, targetSum, parentSum + root.val)){
                return true;
            }
            return false;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsUtils(root, targetSum, 0);
    }
}