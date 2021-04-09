https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//Problem no : 17

class Solution {
    List<String> ans=new ArrayList<>();
    List<String> mapp=Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return ans;
        StringBuilder s=new StringBuilder();
        helper(digits,s,0);
        return ans;
    }
    
    public void helper(String d,StringBuilder s,int index)
    {
        if(d.length()==index)
        {
            ans.add(s.toString());
            return;
        }
        int in=d.charAt(index)-50;
        for(int j=0;j<mapp.get(in).length();j++)
        {
            s.append(mapp.get(in).charAt(j));
            helper(d,s,index+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}