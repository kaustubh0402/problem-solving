https://leetcode.com/problems/word-subsets/
//Problem no : 916

/*
Explanation:
when checking whether "warrior" is a superset of words B = ["wrr", "wa", "or"], 
Initial thought was to check every words in B to every word in A 
But it will give TLE
to avoid above
we can combine these words in B to form a "maximum" word 
"wrr" + "wa" +"or" = "wrrao" (exclude "w" from "wa" as it is already taken) 
"wrrao", that has the maximum count of every letter in each word in B
now we will check for word "wrrao" only for every word in A

*/

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans=new ArrayList<>();
        int b[]=new int[26];
        for(String s:B)
        {
            int bcurr[]=count(s);
            for(int i=0;i<26;i++)
                b[i]=Math.max(b[i],bcurr[i]);
        }
        
        for(String s:A)
        {
            int a[]=count(s);
            int i=0;
            for(i=0;i<26;i++)
                if(a[i]<b[i])
                    break;
            if(i==26)
                ans.add(s);
        }
        return ans;
    }
    
    int[] count(String s)
    {
        int ans[]=new int[26];
        for(int i=0;i<s.length();i++)
            ans[s.charAt(i)-'a']++;
        return ans;
    }
}