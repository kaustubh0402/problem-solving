https://leetcode.com/problems/subarray-sums-divisible-by-k/
//Problem no : 974

/*
Explanation:
Extension of subarray whose sum equal to k
Use prefix sum Array and HashMap
While creating prefix array we will only note remainder in prefix array
   note: If remiander is negative add+k so remainder become positive
         i.e if -1 is remainder of num=-1 and k=5 but -1 is equivivalnet to 4=(-1+5)=(num+k)
HashMap will be (number,frequency)
If prefix sum at two index equal then we will add frequency to answer
There are two menthods for counting answer
  1)Calculate answer at time of adding value in HashMap only
    we will add frequency directly to answer
  2)first add all prefix values in HashMap
    then calculate answer by adding all permutation of equal number
	i.e if v is frequency for num then we will add (v*(v-1)/2)
	suppose we have num 1 for frequency 4 i.e. (1,1,1,1)
	Then we will add (4*(4-1)/2) to answer.i.e 3+2+1=6
*/
class Solution {
    public int subarraysDivByK(int[] A, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int n=A.length;
        int pre[]=new int[n];
        pre[0]=A[0]%k;
        if(pre[0]<0)
            pre[0]=pre[0]+k;
        for(int i=1;i<n;i++)
        {
            pre[i]=(pre[i-1]+A[i])%k;
            if(pre[i]<0)
                pre[i]=pre[i]+k;
        }
        h.put(0,1);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(pre[i]))
                ans+=h.get(pre[i]);
            h.put(pre[i],h.getOrDefault(pre[i],0)+1);
        }
        return ans;
    }
}

//Here Using Array instaed HashMap so speed is Faster
//As Every value in pre[] is less than k (we are taking mod in every)
//So Array will be of size k only
class Solution {
    public int subarraysDivByK(int[] A, int k) {
        int n=A.length;
        int h[]=new int[k];
        int pre[]=new int[n];
        pre[0]=A[0]%k;
        if(pre[0]<0)
            pre[0]=pre[0]+k;
        for(int i=1;i<n;i++)
        {
            pre[i]=(pre[i-1]+A[i])%k;
            if(pre[i]<0)
                pre[i]=pre[i]+k;
        }
        h[0]=1;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=h[pre[i]];
            h[pre[i]]++;
        }
        return ans;
    }
}


