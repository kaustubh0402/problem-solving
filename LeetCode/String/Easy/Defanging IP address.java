https://leetcode.com/problems/defanging-an-ip-address/
//problem no. 1108
class Solution {
    public String defangIPaddr(String address) {
        StringBuffer s=new StringBuffer(address+'#');
        int n=s.length();
        int i=0;
        while(s.charAt(i)!='#')
        {
            if(s.charAt(i)=='.')
            {
                s.insert(i,'[');
                s.insert(i+2,']');
                i+=2;
            }
             i++;   
        }
        s.deleteCharAt(i);
        return s.toString();
    }
}
