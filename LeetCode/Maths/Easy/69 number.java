//https://leetcode.com/problems/maximum-69-number/
//problem no: 69

class Solution {
    public int maximum69Number (int num) {
        int dummy=num;  //copy data to temporary variable
        int position=-1;    // position where we found 6 (will store only last occurence)
        int multiplyer=1;  //its decimal place value where we found 6
        while(dummy!=0)
        {
            if(dummy%10==6)   
                position=multiplyer;  // storing latest index decimal value (From MSB)
            dummy=dummy/10;    // division by 10 to exclude last digit (digit at LSB)
            multiplyer=multiplyer*10;  // increase decimal value by *10
        }
        if(position!=-1)   // check whether 6 is present in digits of number or not
            num=num+3*position;  (if present 6 add (9-6)*decimal value)
        return num;
    }
}