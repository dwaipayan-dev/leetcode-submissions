// Last updated: 6/25/2026, 8:38:28 AM
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode move = head;
        while(move != null) {
            if(move.val == val) {
                if(prev != null) {
                    prev.next = move.next;
                } else {
                    head = head.next;
                }
            } else {
                prev = move;
            }
            move = move.next;
        }
        return head;
    }
}