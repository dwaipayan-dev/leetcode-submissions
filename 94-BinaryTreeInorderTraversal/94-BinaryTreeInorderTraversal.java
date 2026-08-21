// Last updated: 8/21/2026, 7:07:40 AM
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalUtils(root, res);
        return res;
    }

    public void inorderTraversalUtils(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inorderTraversalUtils(root.left, res);
        res.add(root.val);
        inorderTraversalUtils(root.right, res);
    }
}