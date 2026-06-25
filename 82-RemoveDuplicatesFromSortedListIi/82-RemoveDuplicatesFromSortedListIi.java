// Last updated: 6/25/2026, 8:39:38 AM
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode move, ahead, prev;
        move = head;
        ahead = head;
        prev = null;
        while(move != null) {
            int count = 0;
            while(ahead != null && ahead.val == move.val) {
                ahead = ahead.next;
                count++;
            }
            //Remove all nodes starting from move till ahead
            if(count > 1) {
                if(prev == null) {
                    head = ahead;
                    move = ahead;
                } else {
                    prev.next = ahead;
                    move = ahead;
                }
            } else {
                prev = move;
                move = move.next;
            }
        }
        return head;
    }
}