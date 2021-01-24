https://leetcode.com/problems/merge-k-sorted-lists/
//Problem no : 23


/* 
Explanation:
We will Use heap for k sorted LinkedList
we will push only one element form every list given in priority queue(heap)
Then we will smallest element from queue and increment pointer of node which we have remove till queue is empty

Note: Implementation of priority queue of Integer not require compare function
      But object require override of compare function and return value
	  instead of compare we can write((x,y)->x-y)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q=new PriorityQueue<>((x,y)->x.val-y.val);
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null)
                q.offer(lists[i]);
        while(!q.isEmpty())
        {
            ListNode curr=q.poll();
            dummy.next=curr;
            dummy=dummy.next;
            if(curr.next!=null)
                q.offer(curr.next);
        }
        return head.next;
    }
}