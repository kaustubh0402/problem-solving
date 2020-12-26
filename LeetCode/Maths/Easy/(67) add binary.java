https://leetcode.com/problems/add-binary/
//Problem no : 67

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        int n=a.length()-1;
        int m=b.length()-1;
        int carry=0;
        while(m>=0 || n>=0)
        {
            char t1=(n<0)?'0':a.charAt(n);
            char t2=(m<0)?'0':b.charAt(m);
            if(t1=='0' && t2=='0')
            {
                ans.append(carry);
                carry=0;
            }
            else if(t1=='1' && t2=='1')
            {
                ans.append(carry);
                carry=1;
            }
            else
            {
                int temp=(1+carry)%2;
                ans.append(temp);
                carry=carry;
            }
            m--;
            n--;
        }
        if(carry==1)
            ans.append('1');
        ans.reverse();
        return ans.toString();
    }
}