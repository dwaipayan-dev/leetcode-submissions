// Last updated: 6/25/2026, 8:40:19 AM
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode move = curr;
        while(curr != null) {
            move = curr;
            for(int i = 0; i < k-1; i++){
                if(move.next != null )
                    move = move.next;
                else{
                    return head;
                }
            }
            if(prev == null) {
                 head = move;
            }
            ListNode prevTemp = curr;
            ListNode temp = move.next;
            //Reverse logic
            reverse(prev, curr, move);
            curr = temp;
            prev = prevTemp;
            
        }
        return head;
    }

    public void reverse(ListNode prev, ListNode curr, ListNode move) {
        ListNode ending = move.next;
        ListNode starting = curr;
        if(prev != null){
            prev.next = move;
        }
        while(curr != ending){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        starting.next = ending;
    }
}