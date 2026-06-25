// Last updated: 6/25/2026, 8:36:22 AM
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
    public int maxHeight(TreeNode root){
        if(root == null) return 0;
        int left = 1 + maxHeight(root.left);
        int right = 1 + maxHeight(root.right);
        return Math.max(left, right);
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode res = lca(root.left, p, q);
        TreeNode res1 = lca(root.right, p, q);
        if(res != null && res1 != null) return root;
        return res != null? res: res1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int h = maxHeight(root);
        int count = 0;
        TreeNode left = null, right = null;
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.offer(root);
        while(!treeQ.isEmpty()){
            int len = treeQ.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = treeQ.poll();
                if(count == h-1 && i == 0){
                    left = curr;
                }
                if(count == h - 1 && i == len - 1){
                    right = curr;
                }
                if(curr.left != null){
                    treeQ.offer(curr.left);
                }
                if(curr.right != null){
                    treeQ.offer(curr.right);
                }
            }
            count++;
        }
        //System.out.println(left.val);
        //System.out.println(right.val);
        return lca(root, left, right);
    }
}