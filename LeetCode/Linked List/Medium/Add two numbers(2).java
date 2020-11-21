https://leetcode.com/problems/add-two-numbers/
//problem no : 2

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode link1=l1.next;
        ListNode link2=l2.next;
        ListNode answer=new ListNode((l1.val+l2.val)%10);
        ListNode ans=answer;
        int carry=0;
        if((l1.val+l2.val)/10==1)
            carry=1;
        while(link1!=null && link2!=null)
        {
            ListNode temp=new ListNode((link1.val+link2.val+carry)%10);
            ans.next=temp;
            carry=((link1.val+link2.val+carry)/10);
            ans=ans.next;
            link1=link1.next;
            link2=link2.next;
        }
        while(link1!=null)
        {
            ListNode temp=new ListNode((link1.val+carry)%10);
            carry=(link1.val+carry)/10;
            ans.next=temp;
            ans=ans.next;
            link1=link1.next;
        }
        while(link2!=null)
        {
            ListNode temp=new ListNode((link2.val+carry)%10);
            carry=(link2.val+carry)/10;
            ans.next=temp;
            ans=ans.next;
            link2=link2.next;
        }
        if(carry==1){
            ListNode temp=new ListNode(1);
            ans.next=temp;
        }
            return answer;
    }