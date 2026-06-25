// Last updated: 6/25/2026, 8:40:23 AM
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int[] done = new int[2];
        ListNode newlist = new ListNode();
        ListNode head = newlist;
        ListNode[] listArr = new ListNode[2];
        listArr[0] = list1;
        listArr[1] = list2;
        while(true){
            Integer min = null;
            int index = -1;
            for(int i = 0; i < 2; i++){
                if(listArr[i] == null){
                    done[i] = 1;
                    continue;
                }
                if(min == null){
                    min = listArr[i].val;
                    index = i;
                } else {
                    if(min > listArr[i].val){
                        min = listArr[i].val;
                        index = i;
                    }
                }
            }
            if(min == null){
                return head.next;
            } else {
                newlist.next = listArr[index];
                newlist = newlist.next;
                listArr[index] = listArr[index].next;
                newlist.next = null;
            }
        }
    }
}