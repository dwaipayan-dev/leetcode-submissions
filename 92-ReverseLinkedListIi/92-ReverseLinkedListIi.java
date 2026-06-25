// Last updated: 6/25/2026, 8:39:29 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode prevLeft = null;
        ListNode leftPtr = start, rightPtr = start;
        for(int i = 0; i < left; i++){
            prevLeft = leftPtr;
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }
        for(int j = left; j < right; j++){
            rightPtr = rightPtr.next;
        }
        //System.out.println(leftPtr.val);
        //System.out.println(rightPtr.val);
        ListNode prev = rightPtr.next;
        for(int i = left; i <= right; i++){
            ListNode temp = leftPtr.next;
            leftPtr.next = prev;
            prev = leftPtr;
            leftPtr = temp;
        }
        prevLeft.next = rightPtr;
        return start.next;
    }
}