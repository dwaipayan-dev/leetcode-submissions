// Last updated: 6/25/2026, 8:38:51 AM
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
    public void reorderList(ListNode head) {
        //Split the list in 2 parts
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        //Create a stack to store pointers to get in LIFO
        Stack<ListNode> s = new Stack<>();
        ListNode move = second;
        while(move != null) {
            s.push(move);
            move = move.next;
        }

        //Reorder list
        ListNode move1 = first;
        while(!s.isEmpty()) {
            ListNode temp = s.pop();
            temp.next = move1.next;
            move1.next = temp;
            move1 = temp.next;
        }
    }
}