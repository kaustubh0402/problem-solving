https://leetcode.com/problems/find-the-difference/
//Problem no : 389

/*
Explanation:
Total 5 methods:
1.  Brute force (compare every element of s with t ) O(n^2)
2.  Sorting ( sort both s and t string. and check every index of s matching with t) O(nlogn +n)
3.  Using frequency Array (store occurence of character) O(n)
4.  Using sum of all char at t-sum of all char of s (ASCII Value) O(n)
5.  Using XOR of every element of s and t (All same character will 0 due to XOR and remaining will be char which is not present in t)  O(n)
*/


//Solution 5
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0)
            return t.charAt(0);
        int ans=s.charAt(0)^t.charAt(0);
        int i;
        for(i=1;i<s.length();i++)
        {
            ans=ans^(s.charAt(i)^t.charAt(i));
        }
        ans^=t.charAt(i);
        return (char)ans;
    }
}


//Solution 4
class Solution {
    public char findTheDifference(String s, String t) {
        int ans=0;
        int i;
        for(i=0;i<s.length();i++)
        {
            ans+=t.charAt(i)-s.charAt(i);
        }
        ans+=t.charAt(i);
        return (char)ans;
    }
}



//Solution 3
class Solution {
    public char findTheDifference(String s, String t) {
        int freq[]=new int[26];
        int i;
        for(i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']--;
            freq[t.charAt(i)-'a']++;
        }
        freq[t.charAt(i)-'a']++;
        for(int j=0;j<26;j++)
        {
            if(freq[j]==1)
                return (char)('a'+j);
        }
        return ' ';
    }
}



//Solution 2
class Solution {
    public char findTheDifference(String s, String t) {
        char temp[]=s.toCharArray();
        Arrays.sort(temp);
        s=new String(temp);
        temp=t.toCharArray();
        Arrays.sort(temp);
        t=new String(temp);
        int i;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=t.charAt(i))
                return t.charAt(i);
        }
        return t.charAt(i);
    }
}

