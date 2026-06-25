// Last updated: 6/25/2026, 8:38:58 AM
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

public class StackEntry {
    TreeNode node;
    int sum;
    public StackEntry(TreeNode node, int sum){
        this.node = node;
        this.sum = sum;
    }
    public String toString(){
        return Integer.toString(this.sum);
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        int total = 0;
        Stack<StackEntry> s = new Stack<>();
        int sum = 0;
        while(!s.isEmpty() || root != null){
            while(root != null){
                sum = 10*sum + root.val;
                StackEntry se = new StackEntry(root, sum);
                s.push(se);
                System.out.println(s);
                root = root.left;
            }
            if(!s.isEmpty()){
                TreeNode curr = s.peek().node;
                int currSum = s.pop().sum;
                
                if(curr.right != null){
                    root = curr.right;
                    sum = currSum;
                } else {
                    if(curr.left == null)
                        total += currSum;
                }
            }
        }
        return total;
    }
}