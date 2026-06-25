// Last updated: 6/25/2026, 8:38:48 AM
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
    public void postOrderutils(TreeNode root, List<Integer> sequence){
        if(root != null){
            postOrderutils(root.left, sequence);
            postOrderutils(root.right, sequence);
            sequence.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderutils(root, list);
        return list;
    }
}