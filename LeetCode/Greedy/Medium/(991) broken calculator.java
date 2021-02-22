https://leetcode.com/problems/broken-calculator/
//Problem no : 991

/*
Explanation:
Wrong thinking:
 start from X and we will multiply x by 2 each time till X<y 
 add X-Y stpes to above steps as answer
 above method fails
 consider 3 10
 By above method:
 X=6   step=1
 X=12  step=2;
 X-Y=12-10=2  total steps=steps+(X-Y)=2+2=4
 which is wrong 
 correct answer is  X=6 X=5 and X=10 steps=3

Why above methods fail??
  Our Aim is to convert X to Y 
  i.e. Y should final answer
  so we have to start from end i.e Y  
*/

class Solution {
    public int brokenCalc(int X, int Y) {
        if(X>=Y)
            return X-Y;
        int ans=0;
        while(Y>X)
        {
            if((Y&1)==1)
                Y++;
            else
                Y=Y/2;
            ans++;
        }
        return ans+X-Y;
    }
}


//Changing x to y
public int brokenCalc(int X, int Y) {
        int multiple = 1, res = 0;
        while (X * multiple < Y) {
            multiple <<= 1;
            res++;
        }
        int diff = X * multiple - Y;
        while (diff > 0) {  
            res += diff / multiple;
            diff -= diff / multiple * multiple;
            multiple >>= 1;
        }
        return res;
    }