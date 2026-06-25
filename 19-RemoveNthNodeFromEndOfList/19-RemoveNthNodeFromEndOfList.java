// Last updated: 6/25/2026, 8:40:26 AM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode move = head;
        for(int i = 0; i < n; i++){
            move = move.next;
        }
        ListNode target = head;
        while(move != null){
            prev = target;
            target = target.next;
            move = move.next;
        }
        if(prev == null) {
            head = target.next;
            return head;
        }
        prev.next = target.next;
        target.next = null;
        return head;
    }
}