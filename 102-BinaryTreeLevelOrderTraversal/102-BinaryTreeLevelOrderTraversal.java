// Last updated: 6/25/2026, 8:39:23 AM
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
 * }-
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeq = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        } else {
            treeq.offer(root);
            while(!treeq.isEmpty()){
                int levelSize = treeq.size();
                List<Integer> currentLevel = new ArrayList<>();
                for(int i = 0; i < levelSize; i++){
                    TreeNode current = treeq.poll();
                    currentLevel.add(current.val);
                    if(current.left != null){
                        treeq.offer(current.left);
                    }
                    if(current.right != null){
                        treeq.offer(current.right);
                    }
                }
                result.add(currentLevel);
            }
            return result;
        }
    }
}