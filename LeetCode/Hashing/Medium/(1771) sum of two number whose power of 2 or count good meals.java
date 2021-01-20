https://leetcode.com/problems/count-good-meals/
//Problem no : 1771

//Brute force O(n^2)
/*
class Solution {
    public int countPairs(int[] deliciousness) {
        int n=deliciousness.length;
        long ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int total=deliciousness[i]+deliciousness[j];
                if((total & (total-1))==0 && total!=0)
                    ans++;
            }
        }
        int answer=(int)(ans%1000000007);
        return answer;
    }
}
*/

//Improving complexity O(21n) i.e 21 is constant hence O(n);
//Similar to Two Sum problem only difference.
/*
explanation:
n this question, we can use the brute force to check pair by pair, and count. But this O(n^2) solution will give you a TLE.

We can find that we only care about the number of pairs, not what are the pairs. So we can use a HashMap to reduce the search time by O(1). We also need to notice that the number in arr is less than or equal to 2^20, so we can use this info to reduce our search space!

Also since 2^20 + 2^20 = 2^21, so we need to search until 2^21, rather 2^20. That is the testcase [1048576, 1048576]. Here is the code
*/
class Solution {
    public int countPairs(int[] deliciousness) {
        int n=deliciousness.length;
        int ans=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int curr=deliciousness[i];
            for(int j=2097152;j!=0;j/=2)
            {
                if(h.containsKey(j-curr))
                {
                    ans+=h.get(j-curr);
                    ans%=1000000007;
                }
            }
            h.put(curr,h.getOrDefault(curr,0)+1);
        }
        return (int)(ans);
    }
}