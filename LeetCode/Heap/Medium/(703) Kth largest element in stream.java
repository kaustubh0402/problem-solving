https://leetcode.com/problems/kth-largest-element-in-a-stream/
//problem no : 703

Explanation:
We will maintain min heap or priority queue
Now we have to find kth largest for every entry
we will maintain heap of size k in min priorityqueue
This will ensure that only k max elemnts in queue
and peek() will be smallest among k i.e. kth largest
every time we will push elemnt in heap or priority

and if size if greater than k then pop (actuallywe have to check if q size great than k as initial q may be k-1 size)



class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        q=new PriorityQueue<>();
        for(int num:nums)
            q.offer(num);
        while(q.size()>k)
            q.poll();
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k)
          q.poll();
        return q.peek();
    }
}