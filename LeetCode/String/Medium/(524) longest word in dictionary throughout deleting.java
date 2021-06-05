https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
//problem no : 524


class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans="";
        int l=s.length();
        int n=d.size();
        for(int i=0;i<n;i++)
        {
            String curr=d.get(i);
            int curr_len=curr.length();
            int ans_len=ans.length();
            if(ans_len>curr_len)
                continue;
            int index=0;
            for(int j=0;j<l && index<curr_len;j++)
            {
                if(curr.charAt(index)==s.charAt(j))
                    index++;
            }
            if(index==curr_len && (curr_len>ans_len || (curr_len==ans_len && curr.compareTo(ans)<0)))
                ans=curr;
        }
        return ans;
    }
}