https://leetcode.com/problems/bulb-switcher-iii/
//Problem no : 1375

/*
Use concept of natural number sum till natural natural n
For every input check whether sum of input till current imput is equal to sum of natural first i numbers 
if sum of input is greater than sum of natural number of till current input position that means
previous bulb number is missing instaed bulb with gretear number than current input is previous input.
 
*/

class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans=0,sum=0,blue=0;
        for(int i=0;i<light.length;i++)
        {
            sum+=(i+1);
            blue+=light[i];
            if(sum==blue)
                ans++;
        }
        return ans;
    }
}

/*
Using max instaed of sum
Max element till current input must be index of that input(1 base indexing)
*/

class Solution {
    public int numTimesAllBlue(int[] light) {
        int ans=0,max=0;
        for(int i=0;i<light.length;i++)
        {
            max=Math.max(max,light[i]);
            if(max==i+1)
                ans++;
        }
        return ans;
    }
} 