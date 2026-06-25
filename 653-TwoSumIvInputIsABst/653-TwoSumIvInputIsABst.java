// Last updated: 6/25/2026, 8:37:06 AM
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
    public void inorderTraversal(TreeNode root, List<Integer> sortedList){
        if(root != null){
            inorderTraversal(root.left, sortedList);
            sortedList.add(root.val);
            inorderTraversal(root.right, sortedList);
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        int start = 0;
        int end = sortedList.size() - 1;
        while(start < end){
            int t = sortedList.get(start) + sortedList.get(end);
            if(t < k){
                start++;
            } else if(t > k){
                end--;
            } else {
                return true;
            }
        }
        return false;
    }
}