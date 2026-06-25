// Last updated: 6/25/2026, 8:38:53 AM
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode move1 = head;
        ListNode move2 = head;
        ListNode move3 = head;
        boolean cycleExists = false;
        if(head == null) return null;
        while(move1 != null && move2 != null && move2.next != null){
            move1 = move1.next;
            move2 = move2.next.next;
            if(move1 == move2){
                cycleExists = true;
                break;
            }
        }
        if(cycleExists == false) return null;
        else{
            while(move3 != move1){
                move3 = move3.next;
                move1 = move1.next;
            }
            return move3;
        }  
    }
}