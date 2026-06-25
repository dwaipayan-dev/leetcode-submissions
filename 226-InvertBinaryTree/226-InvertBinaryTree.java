// Last updated: 6/25/2026, 8:38:13 AM
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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> treeQ = new LinkedList<>();
        if(root == null) return root;
        treeQ.offer(root);
        while(!treeQ.isEmpty()){
            TreeNode current = treeQ.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null){
                treeQ.offer(current.left);
            }
            if(current.right != null){
                treeQ.offer(current.right);
            }
        }
        return root;
    }
}