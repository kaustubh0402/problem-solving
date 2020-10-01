//https://leetcode.com/problems/increasing-decreasing-string/
//problem no 1370
/*
Explanation:
1) store each char of string in frequency array
2) loop till length of ans is not equal to length of string and do following 
3) two loops one from 0 to 25 and other from 25 to 0
4)  if we found char present then append to answer and decrement freq array val 
*/
//Solution

class Solution {
    public String sortString(String s) {
        int frequency[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            frequency[s.charAt(i)-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        while(ans.length()!=s.length())
        {
            for(int i=0;i<26;i++)
            {
                if(frequency[i]>0)
                {
                    ans.append((char)(i+97));
                    frequency[i]--;
                }
            }
            for(int i=25;i>=0;i--)
            {
                if(frequency[i]>0)
                {
                    ans.append((char)(i+97));
                    frequency[i]--;
                }
            }
        }
        return ans.toString();
    }
}

//Solution with one loop pass only**

class Solution {
    public String sortString(String s) {
        int frequency[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            frequency[s.charAt(i)-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        StringBuilder ans1;
        StringBuilder ans2;
        while(ans.length()!=s.length())
        {
            ans1=new StringBuilder();
            ans2=new StringBuilder();
            for(int i=0;i<26;i++)
            {
                if(frequency[i]>0)
                {
                    ans1.append((char)(i+97));
                    frequency[i]--;
                }
				//This condition ensures that if letter between M and z should be 2 or more as they are not covered in ans1
				//but need not to be true and required freq 1 or more for letter from A to M as thy are already cover in asn1
                if((frequency[25-i]>1 && 25-i>=12) || (frequency[25-i]>0 && 25-i<=12)) 
                {
                    ans2.append((char)(122-i));
                    frequency[25-i]--;
                }
            }
            ans.append(ans1.toString());
            ans.append(ans2.toString());
        }
        return ans.toString();
    }
}

