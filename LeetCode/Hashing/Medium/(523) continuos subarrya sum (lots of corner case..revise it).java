https://leetcode.com/problems/continuous-subarray-sum/
//Problem no : 523

/*
[23,2,4,6,7]
6
[1,1]
-1
[1,2,12]
6
[0,0,0,0,0,0]
1
[0,1,0]
0
[23,2,6,4,7]
0
[23,2,0,0,7]
0
[1,1]
2
[23,0,0]
6
*/

/*
Some corner cases explanation:
when k==0 we cannot use remainder or mod operation
atleast 2 numbers needed so check whther previous number should not equal to current
  if it is equal then answer may contain only 1 number not two
  above case fail when prev number is 0 or nums[i-1]==0 
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int pre[]=new int[n];
        pre[0]=nums[0];
        if(k!=0)
            pre[0]%=k;
        for(int i=1;i<n;i++)
        {
            pre[i]=(pre[i-1]+nums[i]);
            if(k!=0)
                pre[i]%=k;
        }
        HashSet<Integer> h=new HashSet<>();
        int prev=-1;
        for(int i=0;i<n;i++)
        {
            if(h.contains(pre[i]) && (prev!=pre[i] || (prev==0) || nums[i-1]==0))
                return true;
            h.add(pre[i]);
            prev=pre[i];
        }
        if(pre[n-1]==0 && n!=1)
            return true;
        return false;
    }
}