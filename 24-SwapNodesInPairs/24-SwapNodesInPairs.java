// Last updated: 6/25/2026, 8:40:20 AM
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
    public ListNode swapPairs(ListNode head) {
        ListNode move = head;
        ListNode prev = null;
        if(head == null) return head;
        if(move.next != null) head = move.next;
        while(move != null && move.next != null) {
            ListNode ahead = move.next;
            move.next = ahead.next;
            ahead.next = move;
            if(prev != null) {
                prev.next = ahead;
            }
            prev = move;
            move = move.next;
        }
        return head;
    }
}