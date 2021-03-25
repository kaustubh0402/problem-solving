https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
//Problem no : 1326

/*
Explanation:
dp[i] is the minimum number of taps to water [0, i].
Initialize dp[i] with max = n + 2
dp[0] = [0] as we need no tap to water nothing.

Find the leftmost point of garden to water with tap i.
Find the rightmost point of garden to water with tap i.
We can water [left, right] with onr tap,
and water [0, left - 1] with dp[left - 1] taps.
So we will update [left,right] with every iteration i if we find dp[left]+1 minimum than previously stored value

Complexity
Time O(NR), where R = ranges[i] <= 100
Space O(N)
*/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,n+2);
        dp[0]=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=Math.max(0,i-ranges[i]);j<=Math.min(i+ranges[i],n);j++)
            {
                dp[j]=Math.min(dp[j],dp[Math.max(0,i-ranges[i])]+1);
            }
        }
        return dp[n]==n+2?-1:dp[n];
    }
}

/*
Explanation:
As mentioned in question we can water i-ranges[i] and i+ ranges[i]
let left=i-ranges[i] and right=i+ranges[i]
Now we will store value in given range array such that
from given ith point how much max distance we will sprinkel
That i.e. one sprikle can maximum spread left-right
so we will update range[left]=right 
above sentence indicate that at index left it can sprinkle max upto right

Now our aim is to check how many sprinkle we required
We will maintain one variable tillreach which indicate that selected one sprinkle can spread upto that index
We will maintain max_end in between i and tillreach (why??)
Beacause when tillreach exhaused i.e when tillreach==i (ie it can water upto that position)
we required sprinkle which range or spread is maximum which can be given by max_end
and as we are selcting new till reach as max end we will increase our answer by one

*/
class Solution {
    public int minTaps(int n, int[] ranges) {
        for(int i=0;i<=n;i++)
        {
            int l=Math.max(0,i-ranges[i]);
            int r=ranges[i]+i;
			// update the maximum right bound from left bound s
            ranges[l]=Math.max(ranges[l],r);
        }
		//Similar to jump game problem 2
		
        int ans=0;
        int tillreach=0;
        int max_end=0;
        for(int i=0;i<n;i++)
        {
		    //update the max point we can reach.
            max_end=Math.max(max_end,ranges[i]);
            if(i==tillreach)
            {
                // We only have a new jump when we are reaching the furtherest point from previous jump
                // Update the curEnd to the new max point
                ans++;
                tillreach=max_end;
            }
        }
        return tillreach>=n?ans:-1;
    }
}