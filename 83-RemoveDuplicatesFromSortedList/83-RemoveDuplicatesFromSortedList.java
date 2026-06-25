// Last updated: 6/25/2026, 8:39:35 AM
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
        ListNode start = head;
        ListNode prev = null;
        while(head != null){
            if(prev != null){
                if(head.val == prev.val){
                    ListNode temp = head;
                    head = temp.next;
                    prev.next = head;
                    continue;
                }
            }
            prev = head;
            head = head.next;
        }
        return start;
    }
}