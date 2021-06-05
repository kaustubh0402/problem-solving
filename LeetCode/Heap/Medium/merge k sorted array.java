https://www.interviewbit.com/problems/merge-k-sorted-arrays/
https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1#


public class Solution {
    class bundle
    {
        int index;
        int val;
        int arr_index;
        bundle(int arr_index,int index,int val)
        {
            this.arr_index=arr_index;
            this.index=index;
            this.val=val;
        }
    }
    
    public int[] solve(int[][] A) {
        int k=A.length;
        int n=A[0].length;
        int ans[]=new int[n*k];
        PriorityQueue<bundle> q=new PriorityQueue<>((x,y)->x.val-y.val);
        for(int i=0;i<k;i++)
            q.offer(new bundle(i,0,A[i][0]));
        int i=0;
        while(!q.isEmpty())
        {
            bundle curr=q.poll();
            ans[i++]=curr.val;
            int pointer=curr.index;
            int arr_pointer=curr.arr_index;
            if(pointer!=n-1)
              q.offer(new bundle(arr_pointer,pointer+1,A[arr_pointer][pointer+1]));
        }
        return ans;
    }
}
