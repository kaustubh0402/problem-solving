https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
//Problem no : 1721

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start=head;
        ListNode end=head;
        for(int i=0;i<k-1;i++)
            start=start.next;
        
        ListNode temp=start;
        while(temp.next!=null)
        {
            temp=temp.next;
            end=end.next;
        }
        int swap=end.val;
        end.val=start.val;
        start.val=swap;
        return head;
    }
}