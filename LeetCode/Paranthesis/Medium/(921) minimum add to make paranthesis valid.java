https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
//Problem no : 921

/*
Explanation:
Algorithm:
  1) We will push if we found open bracket in stack
  2) if we found close bracket
     1) We eill check if it have open bracket in stack or not if yes pop froom stack
	 2) else we have to insert open bracket so we have to increment ans
  3) at last if stack is not empty then we required close bracket for open bracket in stack
     so we add stack of size to ans
	 
Note: Actually we can use count variable to store count of open bracket instead of stack
*/

class Solution {
    public int minAddToMakeValid(String S) {
        int n=S.length();
        int ans=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            char curr=S.charAt(i);
            if(curr=='(')
                count++;
            if(curr==')')
            {
                if(count==0)
                    ans++;
                else
                    count--;
            }
        }
        return ans+count;
    }
}

//Stack solution
 public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character> ();
        int counter = 0;
        for(int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if(temp == '(') {
                stack.push(temp);
            }
            else if(!stack.isEmpty()) {
                stack.pop();
            }
            else counter++;
        }
        return counter + stack.size();
	}