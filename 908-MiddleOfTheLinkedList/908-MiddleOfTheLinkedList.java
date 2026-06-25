// Last updated: 6/25/2026, 8:36:38 AM
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
    public ListNode middleNode(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        while(hare.next != null && hare.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        if(hare.next == null){
            return turtle;
        }
        else{
            return turtle.next;
        }
    }
}