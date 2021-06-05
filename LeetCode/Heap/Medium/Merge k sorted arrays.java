https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1#


class Solution{
    static class bundle
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
    public static ArrayList<Integer> mergeKArrays(int[][] a,int k) 
    {
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<bundle> q=new PriorityQueue<>((x,y)->x.val-y.val);
        for(int i=0;i<k;i++)
            q.offer(new bundle(i,0,a[i][0]));
        while(!q.isEmpty())
        {
            bundle curr=q.poll();
            ans.add(curr.val);
            int pointer=curr.index;
            int arr_pointer=curr.arr_index;
            if(pointer<k-1)
              q.offer(new bundle(arr_pointer,pointer+1,a[arr_pointer][pointer+1]));
        }
        return ans;
    }
}