https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#

/*
Explanation:
It is same as detect cycle in linked list II 
But one extra condition is added 
As we required to remve loop we have to make next pointer of node before common node to be null
i.e in condition we will check for slow.next!=fast.next
But one corner cases should be consider what if starting point of linked is same as common point of meet
Then we have to traverse linked list again.
*/

class solver
{
    public static void removeLoop(Node head){
        int flag=1;
        Node slow=head;
        Node fast=head;
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
            return;
        slow=head;
        if(slow==fast) //This is extra condition if head and common meeting point is same
        {
            fast=fast.next;
            while(fast.next!=slow)
            {
                fast=fast.next;
            }
            fast.next=null;
            return;
        }
        while(fast.next!=slow.next)
        {
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }
}