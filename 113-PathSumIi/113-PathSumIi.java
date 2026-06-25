// Last updated: 6/25/2026, 8:39:15 AM
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
    public void pathSumUtils(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> allPaths, int currSum){
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                allPaths.add(new ArrayList<>(currPath));
            }
        } else {
            if(root.left != null){
                currSum += root.left.val;
                currPath.add(root.left.val);
                pathSumUtils(root.left, targetSum, currPath, allPaths, currSum);
                currSum -= root.left.val;
                currPath.remove(currPath.size() - 1);
            }
            if(root.right != null){
                currSum += root.right.val;
                currPath.add(root.right.val);
                pathSumUtils(root.right, targetSum, currPath, allPaths, currSum);
                currSum -= root.right.val;
                currPath.remove(currPath.size() - 1);
            }
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        if(root == null) return allPaths;
        currPath.add(root.val);
        int currSum = root.val;
        pathSumUtils(root, targetSum, currPath, allPaths, currSum);
        return allPaths;
    }
}