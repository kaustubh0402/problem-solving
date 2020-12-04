https://leetcode.com/problems/linked-list-random-node/
//Problem no : 382


//following is not space optimal solution
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
    ArrayList<Integer> store=new ArrayList<Integer>();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        while(head!=null)
        {
            store.add(head.val);
            head=head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return (store.get(ThreadLocalRandom.current().nextInt(0,store.size())));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */