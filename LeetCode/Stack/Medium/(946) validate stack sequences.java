https://leetcode.com/problems/validate-stack-sequences/
//Problem no : 946

/*
Explanation:
We can push numbers without restriction as input is given
So we have to validate while popping elements from popped array
There are two cases:
1) if current element needed to pop from array is yet to be pushed
      i.e. we have to push elements in stack till we found current popped element in push array
			if we doesnot found element then return false else move to next iteration
2) if(current element is already pushed 
    i) then either current element should be at top of stack then we will continue
	ii) else it will follow case 1) and return false.
*/


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length;
        int m=popped.length;
        int i=0;
        int j=0;
        Stack<Integer> st=new Stack<>();
        while(i<m)
        {
            if(!st.isEmpty() && popped[i]==st.peek())
            {
                i++;
                st.pop();
            }
            else
            {
                while(j<n && pushed[j]!=popped[i])
                {
                    st.push(pushed[j]);
                    j++;
                }
                if(j==n)
                    return false;
                i++;
                j++;
            }
        }
        return true;
    }
}

//Clean code
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}