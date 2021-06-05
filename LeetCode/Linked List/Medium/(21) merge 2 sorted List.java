https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1#
https://leetcode.com/problems/merge-two-sorted-lists/
//Problem no : 21


class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
        Node curr=new Node(0);
        Node head=curr;
        while(headA!=null || headB!=null)
        {
            if(headA==null)
            {
                curr.next=headB;
                break;
            }
            if(headB==null)
            {
                curr.next=headA;
                break;
            }
            if(headA.data<=headB.data)
            {
                curr.next=headA;
                headA=headA.next;
            }
            else
            {
                curr.next=headB;
                headB=headB.next;
            }
            curr=curr.next;
        }
        return head.next;
   } 
}