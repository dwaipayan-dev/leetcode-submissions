# Last updated: 6/25/2026, 8:36:43 AM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if(head is None):
            return None
        else:
            p = head
            q = head
            while(q.next is not None and q.next.next is not None):
                p = p.next
                q = q.next.next
            if(q.next is None):
                return p
            else:
                return p.next
        
        