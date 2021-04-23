https://leetcode.com/problems/replace-words/
//Problem no : 648

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> h=new HashSet<>(dictionary);
        String arr[]=sentence.split(" ");
        int n=arr.length;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            String curr=arr[i];
            int len=curr.length();
            StringBuilder temp=new StringBuilder();
            int j=0;
            for(j=0;j<len;j++)
            {
                temp.append(curr.charAt(j));
                if(h.contains(temp.toString()))
                {
                    ans.append(temp);
                    break;
                }
            }
            if(j==len)
                ans.append(temp);
            if(i!=n-1)
                ans.append(" ");
        }
        return ans.toString();
    }
}