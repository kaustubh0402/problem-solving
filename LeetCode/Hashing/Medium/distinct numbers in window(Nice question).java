https://www.interviewbit.com/problems/distinct-numbers-in-window/
//Distinct numbers in window


public class Solution {
    public int[] dNums(int[] A, int B) {
        int n=A.length;
        if(B>n)
          return new int[0];
        int ans[]=new int[n-B+1];
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<B;i++)
          h.put(A[i],h.getOrDefault(A[i],0)+1);
        ans[0]=h.size();
        int in=1;
        for(int i=B;i<n;i++)
        {
            h.put(A[i-B],h.get(A[i-B])-1);
            if(h.get(A[i-B])==0)
            {
                h.remove(A[i-B]);
            }
            if(h.containsKey(A[i]))
            {
                h.put(A[i],h.get(A[i])+1);
            }
            else
            {
                h.put(A[i],1);
            }
            ans[in]=h.size();
            in++;
        }
        return ans;
    }
}