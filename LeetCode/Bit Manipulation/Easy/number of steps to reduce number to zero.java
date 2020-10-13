https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
//problem no: 1342
class Solution {
    public int numberOfSteps (int num) {
        int ans=0;
        while(num!=0)
        {
            if((num & 1)==0)
                num=num>>1;
            else
                num=num-1;
            ans++;
        }
        return ans;
    }
}
