https://leetcode.com/problems/swap-nodes-in-pairs/
// Problem no : 24


//not actual node swapping just value swapping
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode first=head;
        ListNode second=head.next;
        while(first!=null && second!=null)
        {
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
            first=first.next.next;
            second=second.next==null?null:second.next.next;
        }
        return head;
    }
}



//try to dry run program
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode curr=head;
        ListNode ans=head.next;
        while(curr!=null && curr.next!=null)
        {
            ListNode first=curr;
            curr=curr.next;
            first.next=curr.next;
            curr.next=first;
            curr=first.next;
            if(curr!=null && curr.next!=null)
               first.next=curr.next;
        }
        return ans;
    }
}