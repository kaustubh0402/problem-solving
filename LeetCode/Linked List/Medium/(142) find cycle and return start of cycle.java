https://leetcode.com/problems/linked-list-cycle-ii/submissions/
//Problem no : 142


/*
Explanation:
First we will find whether cycle present or not 
For that we will use slow and fast pointer
slow pointer==moves by one position
fast pointer==moves by two position

Suppose if cycle is present then any pointer will not reach null
After some time slow and fast pointer meet if cycle is there

Then we have to find length of cycle ...why??
Suppose some how yo find length of cycle then your question turn into
find elemnt at distance n(length of cycle) from end of linkedlist
differnce here is end of list is not null but common pointer

Now how to find length??
You can initiate variable l for length and 
now only travel slow pointer till again meet fast pointer and increment l

IMPORTANT:
but no need to find length again as we alreday know length
just move fast pointer to start and increment both slow and fast by 1 while they meet each other
for intution watch Take u forward find missing number solution
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int flag=1;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
            return null;
        slow=head;
        while(fast!=slow)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}