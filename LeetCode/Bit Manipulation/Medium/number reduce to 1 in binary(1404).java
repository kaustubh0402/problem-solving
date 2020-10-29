https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
//Problem no : 1404

/*
Explanation:
First we have to consider extra 0 at MSB as it may possible that it will used when case '111'
We have to perform 2 operation:
if odd then LSB will always 1
so we have to add 1
Result after adding 1 will be all bits from LSB to till we find 0 will be 0 and first 0 from LSB will be 1 (Step++) (Do not decrement index as it will not reduce bit)
Now for  even we have to just remove LSB (i.e steps++ and index--)
*/


class Solution {
    public int numSteps(String s) {
        char arr[]=('0'+s).toCharArray();
        int steps=0;
        int len=s.length()+1;
        for(int i=len-1;i>=1;)
        {
            if(i!=1 && arr[i]=='1')
            {
                steps++;
                while(i>=0 && arr[i]!='0')
                {
                    steps++;
                    i--;
                }
                if(i>=0)
                    arr[i]='1';
            }
            else
            {
                steps++;
                i--;
                
            }
        }
        if(arr[0]=='0')
            return steps-1;
        return steps;
    }
}
