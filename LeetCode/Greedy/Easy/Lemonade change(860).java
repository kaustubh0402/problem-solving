https://leetcode.com/problems/lemonade-change/
//Problem no : 860

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
                five+=5;
            else if(bills[i]==10)
            {
                if(five<5)
                    return false;
                five-=5;
                ten+=10;
            }
            else if(bills[i]==20)
            {
                if(ten<10)
                {
                    if(five<15)
                        return false;
                    else 
                        five-=15;
                }
                else if(ten>=10)
                {
                    if(five<5)
                        return false;
                    else
                    {
                        ten-=10;
                        five-=5;
                    }
                }
            }
        }
        return true;
    }
}