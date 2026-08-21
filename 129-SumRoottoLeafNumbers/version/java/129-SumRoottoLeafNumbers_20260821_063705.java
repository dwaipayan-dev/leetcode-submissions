// Last updated: 8/21/2026, 6:37:05 AM
/*
 * This solution is a simple preorder traversal with calculation of path at and storing path whenever leaf node is encountered. 
 * 
 * Time complexity: O(n)
 * Space complexity O(logn) / worst case O(N) for skewed tree
*/

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
17    public int sumNumbers(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19        traverse(root, res, 0);
20        int sum = res.stream().reduce(0, (a,b) -> a + b);
21        return sum;
22    }
23
24    public void traverse(TreeNode root, List<Integer> res, int t) {
25        if(root == null) {
26            return;
27        }
28        t = 10*t + root.val;
29        if(root.left == null && root.right == null) {
30            res.add(t);
31        }
32        if(root.left != null)
33            traverse(root.left, res, t);
34        if(root.right != null)
35            traverse(root.right, res, t);
36    }
37}