https://leetcode.com/problems/sliding-window-maximum/
//Problem no : 239

/*
explanation from basic:
https://www.youtube.com/watch?v=xFJXtB5vSmM

My idea:
Brute force: O(n*k)  
 we will find repeated maximum elemnts using two nexted loop
 outer loop from 1 to n and inner loop of 1 to i+k
 
Optimize:
Following two things we have to achieve:
1) Remove from front of array
2) Insert in back of array or window

From that we get we have to use queue
we will use double ended queue that also monotonous
i.e queue will be index of elemnts in decreasing order (as we want maximum elemnt only)
thus maximum elemnt will be at front of queue (q.peek())
We will remove from front till index greater than i-k (to maintain window size)
and add elemnt while maintaining decrasing order

Note: maxium elemnt in iteration will be of previous window
so find max elemnt of last window explicitely outside loop 
*/


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new LinkedList<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<k;i++)
        {
            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()])
              q.removeLast();
            q.addLast(i);
        }
        for(int i=k;i<n;i++)
        {
            ans[i-k]=nums[q.peek()];
            while(!q.isEmpty() && q.peek()<=i-k)
              q.removeFirst();
            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()])
              q.removeLast();
            q.addLast(i);
        }
        ans[n-k]=(nums[q.peek()]);
        return ans;
    }
}