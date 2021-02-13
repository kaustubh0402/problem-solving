https://www.geeksforgeeks.org/find-the-count-of-unvisited-indices-in-an-infinite-array/


class Solution{
    static int candies(int m, int n)
    {
        int last=(m*n)-m-n;
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> h=new HashSet<>();
        q.add(last);
        h.add(last);
        int count=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            if(curr-m>0 && !h.contains(curr-m))
            {
                q.add(curr-m);
                h.add(curr-m);
            }
            if(curr-n>0 && !h.contains(curr-n))
            {
                q.add(curr-n);
                h.add(curr-n);
            }
            count++;
        }
        return count;
    }
}