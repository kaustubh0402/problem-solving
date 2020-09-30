//https://leetcode.com/problems/print-words-vertically/
//problem no: 1324
/*
Explanation:
note: Here max_index[] array is only used to not use inbuilt trim function
Algorithm:
1) find largest length word (max_count)  in given string which will be number of words in final answer
2) then iterate over all words of string for max_count times and add each letter of word to max_count words in ans with some condition
*/

My solution

class Solution {
    public List<String> printVertically(String s) {
        List <String> word =new ArrayList<String>();
        StringBuilder temp=new StringBuilder();
        int max_count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
                temp.append(s.charAt(i));
            else
            {
                word.add(temp.toString());
                max_count=Math.max(max_count,temp.length());
                temp=new StringBuilder();
            }
        }
                word.add(temp.toString());
                max_count=Math.max(max_count,temp.length());
                temp=new StringBuilder();
        
        int max_index[]=new int[word.size()];
        max_index[word.size()-1]=word.get(word.size()-1).length();
        for(int i=word.size()-2;i>=0;i--)
        {
            max_index[i]=Math.max(max_index[i+1],word.get(i).length());
        }
        
        List <String> ans=new ArrayList<String>();
        for(int i=0;i<max_count;i++)
        {
            temp=new StringBuilder();
            for(int j=0;j<word.size();j++)
            {
                if(i<word.get(j).length())
                    temp.append(word.get(j).charAt(i));
                else if(ans.size()<max_index[j])
                    temp.append(" ");
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}

/*
without max_index and using Righttrim()
String[]str=s.split(" ");
    List<String>list=new ArrayList<>();
    int max=0;
    for(String st:str){
        max=Math.max(max,st.length());
    }    
    for(int i=0;i<max;i++){
        StringBuilder sb=new StringBuilder();
        for(String st:str){
            if(i<st.length()){
                sb.append(st.charAt(i));
            }else{
                sb.append(" ");
            }
        } 
        list.add(sb.toString().stripTrailing());
    }      
    return list;
*/