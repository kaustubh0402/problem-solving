https://leetcode.com/problems/middle-of-the-linked-list/
//problem no : 876

//optimal : Slow and fast pointer (single pass O(n))
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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;    
        }
        return slow;
    }
}



//O(n) = 2 pass
//Calculate lenght and then another loop till half of linked list
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
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            temp=temp.next; 
            count++;
        }
        System.out.println(count);
        count=count/2;
        System.out.println(count);
        ListNode temp1=head;
        while(count>0)
        {
            temp1=temp1.next;
            count--;
        }
        return temp1;
    }
}

