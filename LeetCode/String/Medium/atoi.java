//https://leetcode.com/problems/string-to-integer-atoi/
//problem no. 8
//My solution
class Solution {
    public int myAtoi(String str) {
        int n=str.length();
        int i=0,ans=0,flags=0,flagsp=0;
        char sign='+';
        ArrayList<Integer> s=new ArrayList<Integer>();
        while(i!=n)
        {
            char current=str.charAt(i);
            if(current==' ')
            {
                if(flagsp==1)
                    return value(s,sign);
                i++;
                continue;
            }
            else if(current=='+' || current=='-')
            {
                if(flags==0)
                    sign=current;
                else if(flags==1)
                    return value(s,sign);
                flags=1;
                flagsp=1;
            }
            else if(current>=48 && current<=57)
            {
                s.add(Integer.valueOf(current-48));
                flagsp=1;
                flags=1;
            }
            else
            {
                return value(s,sign);
            }
            i++;
        }
        return value(s,sign);
    }
    public int value(ArrayList<Integer> num,char sign)
    {
        long ans=0;
        long x=1;
        while(num.size()>0 && num.get(0)==0) //remove excees 0 at start
        {
            num.remove(0);
        }
        if(num.size()>10)   // if value is excedding long for test case 100000000000000000000000000000000000000000000034536536
        {
            if(sign=='+')
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
            
        for(int i=num.size()-1;i>=0;i--)
        {
            // System.out.println(num.get(i));
            long val;
            if(sign=='+')
                val=ans+num.get(i)*x;
            else
                 val=ans-num.get(i)*x;
            if(val>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(val<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            ans=val;
            x=x*10;
        }
        return (int)ans;
    }
}

/*
clean code
class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }
}
*/