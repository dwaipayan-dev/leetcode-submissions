// Last updated: 6/25/2026, 8:39:53 AM
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int length = 1;
        if(tail == null){
            return head;
        }
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        int rotateBy = k % length;
        if(rotateBy == 0){
            return head;
        }
        rotateBy = length - rotateBy;
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 0; i < rotateBy; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        tail.next = head;
        head = curr;
        return head;
    }
}