https://leetcode.com/problems/linked-list-cycle/
//Problem no: 141


public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            if(slow==fast)
                return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}