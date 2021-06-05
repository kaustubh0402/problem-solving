//https://leetcode.com/problems/valid-parentheses/
//problem no 20
//My solution
class Solution {
    public boolean isValid(String s) {
        Stack <Character> st =new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                st.push(s.charAt(i));
            else
            {
                if(st.empty())
                    return false;
                char temp=st.pop();
                if(s.charAt(i)==')' && temp!='(')
                {
                    return false;
                }
                else if(s.charAt(i)=='}' && temp!='{')
                {
                    return false;
                }
                else if(s.charAt(i)==']' && temp!='[')
                {
                    return false;
                }
            }
        }
        if(!st.empty())
            return false;
        return true;
    }
}
 /*
 Alternative solution
public boolean isValid(String s) {

     if(s.length() % 2 == 1)
        return false;
     
     Stack<Character> stack = new Stack<Character>();
	 for(int i = 0; i < s.length(); i++)
	 {
		if(s.charAt(i) == '(')
		{
			stack.push(')');
		}
		else if(s.charAt(i) == '{')
		{
			stack.push('}');
		}
		else if(s.charAt(i) == '[')
		{
			stack.push(']');
		}
		else if(stack.isEmpty() || stack.pop() != s.charAt(i))
			return false;
	 }
	 return stack.isEmpty();
}
*/