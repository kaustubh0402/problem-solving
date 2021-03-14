https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
//problem no : 1461

/*
Explanation:
Brute force approach:
we will generate all substring of given length k for binaray string
Total string : 2^k
time complexity wil be 2^k for generating strig
and using kmp algorithm checking each substring present in string or not O(n)
Total Time complexity:  (2^k * n)

Now how to optimize??
One thing we know that we have to found only all substring i.e 2^k present in string or not
i.e we are concern with number of substrings  not actual substring
Now we will calculate how many distinct substring of given length k can be formed in string of lengtn n
that can be found in O(n)*k (By traversing string of length n)

We will use hashset for storing distinct substring of length k/
if lenght of hashset is 2^k then return true

*/
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        int total=(int)Math.pow(2,k);
        if(n<total)
            return false;
        HashSet<String> h=new HashSet<>();
        StringBuilder curr=new StringBuilder();
        for(int i=0;i<k;i++)
        {
            curr.append(s.charAt(i));
        }
        h.add(curr.toString());
        for(int i=k;i<n;i++)
        {
            curr.deleteCharAt(0);
            curr.append(s.charAt(i));
            h.add(curr.toString());
            if(h.size()==total)
                return true;
        }
        if(h.size()==total)
            return true;
        return false;
    }
}