https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
problem no : 1290

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