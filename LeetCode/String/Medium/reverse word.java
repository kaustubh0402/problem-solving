//https://leetcode.com/problems/reverse-words-in-a-string/
//problem no 151

class Solution {
    public String reverseWords(String s) {
        //final answer will store in ans
        StringBuilder ans=new StringBuilder();
        // it will store each word as it is till we find space char
        StringBuilder temp=new StringBuilder();
       // flag is to check whether no more than 2 space should between two words
        int flag=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
            {
                temp.append(s.charAt(i));
                flag=0; // as we need one space after each word
            }
            else
            {
                if(flag==0) //if flag is 0 then space is found for first time 
		         //so insert previous one word at starting
                {
                    ans.insert(0,temp);
                    temp=new StringBuilder();
                    if(i!=0 && i!=s.length()-1)// to check space is not at end or start
                    {
                        ans.insert(0,' '); // one space insertion
                    }
                } 
                flag=1; // it indicate one space already added 
            }
        }
        ans.insert(0,temp); // if we not found any space at end
        return ans.toString().trim();
// trim for case when thera are more than one space at end
    }
}

/*
Without using trim function
class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        int flag=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
            {
                temp.append(s.charAt(i));
                flag=0;
            }
            else
            {
                if(flag==0)
                {
                    if(ans.length()!=0)
                       ans.insert(0,' ');
                    ans.insert(0,temp);
                    temp=new StringBuilder();
                    
                } 
                flag=1;
            }
        }
        if(temp.length()!=0 && ans.length()!=0)
            ans.insert(0,' ');
        ans.insert(0,temp);
        return ans.toString();
    }
}
*/