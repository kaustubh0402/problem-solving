https://leetcode.com/problems/partition-list/
//Problem no : 86

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
    public ListNode partition(ListNode head, int x) {
        ListNode first=null;
        ListNode second=null;
        if(head==null)
            return head;
        ListNode bfirst=new ListNode(0);
        ListNode bsecond=new ListNode(0);
        first=bfirst;
        second=bsecond;
        while(head!=null)
        {
            if(head.val<x)
            {
                first.next=head;
                first=first.next;
            }
            else
            {
                second.next=head;
                second=second.next;
            }
            head=head.next;
        }
        second.next=null;
        first.next=bsecond.next;
        return bfirst.next;
    }
}