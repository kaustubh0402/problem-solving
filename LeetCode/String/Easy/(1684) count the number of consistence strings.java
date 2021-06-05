https://leetcode.com/problems/count-the-number-of-consistent-strings/
//problem no : 1684

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int arr[]=new int[26];
        int count=0;
        for(int i=0;i<allowed.length();i++)
            arr[allowed.charAt(i)-97]++;
        for(String  n: words)
        {
            int i;
            for(i=0;i<n.length();i++)
            {
                if(arr[n.charAt(i)-97]<=0)
                    break;
            }
            if(i==n.length())
                count++;
        }
        return count;
    }
}