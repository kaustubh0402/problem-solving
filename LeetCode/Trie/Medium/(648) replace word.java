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


//Use of trie:
class Solution {
    class node
    {
        node children[]=new node[26];
        int end=0;
    }
    
    node root;
    public Solution() {
        root=new node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        node curr=root;
        int n=word.length();
        int i=0;
        while(i!=n)
        {
            int now=word.charAt(i)-97;
            if(curr.children[now]==null)
                curr.children[now]=new node();
            curr=curr.children[now];
            i++;
        }
        curr.end=1;
    }
    
    /** Returns if the word is in the trie. */
    public String replace(String word) {
        node curr=root;
        int n=word.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            int now=word.charAt(i)-97;
            if(curr.end==1)
                return ans.toString();
            ans.append(word.charAt(i));
            if(curr.children[now]==null)
                return word;
            curr=curr.children[now];
        }
        return word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        int n=dictionary.size();
        for(int i=0;i<n;i++)
            insert(dictionary.get(i));
        
        StringBuilder ans=new StringBuilder();
        String arr[]=sentence.split(" ");
        
        for(int i=0;i<arr.length;i++)
        {
            ans.append(replace(arr[i]));
            if(i!=arr.length-1)
                ans.append(" ");
        }
        return ans.toString();
    }
}