https://leetcode.com/problems/roman-to-integer/
//Problem no : 13

/*
Explanation:
observation::::
1) consider I:
   1) if I comes before bigger number than I then we will -1 (i.e IV is 5-1)
   2) if I comes after bigger number than I then we will add +1 (i.e. VI is 5+1)
This will hold for all numbers
*/
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int n=s.length();
        int ans=h.get(s.charAt(n-1));
        for(int i=n-2;i>=0;i--)
        {
            int curr=h.get(s.charAt(i));
            int next=h.get(s.charAt(i+1));
            if(next>curr)
                ans=ans-curr;
            else
                ans=ans+curr;
        }
        return ans;
    }
}