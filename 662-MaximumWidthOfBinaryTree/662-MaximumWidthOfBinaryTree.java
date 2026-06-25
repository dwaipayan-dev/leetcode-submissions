// Last updated: 6/25/2026, 8:37:05 AM
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        q.offer(root);
        m.put(root, 1);
        int currWidth = 0;
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode tempNode = q.poll(); 
                if(i == 0) start = m.get(tempNode);
                if(i == size - 1) end = m.get(tempNode);
                if(tempNode.left != null){
                    m.put(tempNode.left, m.get(tempNode) * 2);
                    q.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    m.put(tempNode.right, m.get(tempNode) * 2 +1);
                    q.offer(tempNode.right);
                }
            }
            currWidth = end - start + 1;
            maxWidth = Math.max(currWidth, maxWidth);
        }
        return maxWidth;
    }
}