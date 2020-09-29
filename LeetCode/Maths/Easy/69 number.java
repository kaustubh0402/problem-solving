//https://leetcode.com/problems/maximum-69-number/
//problem no: 69

class Solution {
    public int maximum69Number (int num) {
        int dummy=num;
        int position=-1;
        int multiplyer=1;
        while(dummy!=0)
        {
            if(dummy%10==6)
                position=multiplyer;
            dummy=dummy/10;
            multiplyer=multiplyer*10;
        }
        if(position!=-1)
            num=num+3*position;
        return num;
    }
}