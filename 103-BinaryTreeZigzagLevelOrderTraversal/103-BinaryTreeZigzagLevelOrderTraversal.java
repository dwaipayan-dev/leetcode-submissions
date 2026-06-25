// Last updated: 6/25/2026, 8:39:21 AM
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<>();
        if(root == null) return allLevels;
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.offer(root);
        boolean count = false;
        while(!treeQ.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = treeQ.size();
            for(int i = 0; i < size; i++){
               TreeNode current = treeQ.poll();
               level.add(current.val);
               if(current.left != null) treeQ.offer(current.left);
               if(current.right != null) treeQ.offer(current.right);
            }
            if(count == true){
                int start = 0;
                int end = level.size() - 1;
                while(start < end){
                    int temp = level.get(start);
                    level.set(start, level.get(end));
                    level.set(end, temp);
                    start++;
                    end--;
                }
            }
            allLevels.add(level);
            count = !count;
        }
        return allLevels;
    }
}