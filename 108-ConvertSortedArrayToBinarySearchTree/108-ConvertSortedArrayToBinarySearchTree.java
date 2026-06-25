// Last updated: 6/25/2026, 8:39:19 AM
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
    public static int[] slice(int[] arr, int left, int right) {
        if(left > right) {
            return new int[0];
        }
        int[] newArr = new int[right - left + 1];
        int index = 0;
        for(int i = left; i <= right; i++) {
            newArr[index++] = arr[i];
        }
        return newArr;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length <= 0) {
            return null;
        }
        int val = nums[nums.length/2];
        TreeNode left = sortedArrayToBST(slice(nums, 0, nums.length/2 - 1));
        TreeNode right = sortedArrayToBST(slice(nums, nums.length/2 + 1, nums.length -1));
        return new TreeNode(val, left, right);
    }
}