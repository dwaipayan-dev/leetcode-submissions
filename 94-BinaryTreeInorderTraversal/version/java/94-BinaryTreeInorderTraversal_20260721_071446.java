// Last updated: 7/21/2026, 7:14:46 AM
// Simple recursion. O(n) time complexity as each node is traversed once
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19        inorderTraversalUtils(root, res);
20        return res;
21    }
22
23    public void inorderTraversalUtils(TreeNode root, List<Integer> res) {
24        if(root == null) return;
25        inorderTraversalUtils(root.left, res);
26        res.add(root.val);
27        inorderTraversalUtils(root.right, res);
28    }
29}