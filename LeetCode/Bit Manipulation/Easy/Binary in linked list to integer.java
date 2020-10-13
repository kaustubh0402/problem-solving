https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
//Problem no:1290

//Optimal
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;    
        }
        return num;
    }
}


//bruteForce
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
    public int getDecimalValue(ListNode head) {
        int ans=0;
        ArrayList <Integer> a=new ArrayList<Integer>();
        ListNode temp=head;
        while(head!=null)
        {
            a.add(head.val);
            head=head.next;
        }
        for(int i=a.size()-1;i>=0;i--)
        {
            ans=ans+(int)Math.pow(2,a.size()-i-1)*a.get(i);
        }
        return ans;
    }
}

//Optimal one loop

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans=0;
        int raise=30;
        while(head!=null)
        {
            ans=ans+(int)Math.pow(2,raise)*head.val;
            raise--;
            head=head.next;
        }
        ans=ans>>(raise+1);
        return ans;
    }
}
