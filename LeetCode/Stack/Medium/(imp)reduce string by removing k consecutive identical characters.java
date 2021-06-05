https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/

/*
Hint : maintain stack of object of character and frequency)
*/

class Solution
{
    class freq
    {
        int count;
        char c;
        freq(char c,int count)
        {
            this.c=c;
            this.count=count;
        }
    }
    
    public String reduced_String(int k, String s)
    {
        Stack<freq> st=new Stack<freq>();
        int n=s.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(!st.isEmpty() && (st.peek().count==k))
            {
                char remove=st.peek().c;
                while(!st.isEmpty() && st.peek().c==remove)
                  st.pop();
            }
            if(!st.isEmpty() && st.peek().c==curr)
              st.push(new freq(curr,st.peek().count+1));
            else
              st.push(new freq(curr,1));
        }
        if(!st.isEmpty() && (st.peek().count==k))
        {
            char remove=st.peek().c;
            while(!st.isEmpty() && st.peek().c==remove)
              st.pop();
        }
        while(!st.isEmpty())
          ans.append(st.pop().c);
        return ans.reverse().toString();
    }
}