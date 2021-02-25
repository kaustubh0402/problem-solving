https://leetcode.com/problems/min-stack/
//Problem no : 155

/*
Explanation:
Normal stack can be perform pop(),push() and peek() in O(1)
But we have to implement min element in O(1)
So we will maintain one another stack for min element till that point
Note:We can also use pair object with only one stack
          pair<Integer,Integer> =pair(element,min_element till point)
*/



class MinStack {

    Stack<Integer> ans;
    Stack<Integer> min;
    public MinStack() {
        ans=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int x) {
        ans.push(x);
        if(min.isEmpty())
            min.push(x);
        else
            min.push(Math.min(min.peek(),x));
    }
    
    public void pop() {
        ans.pop();
        min.pop();
    }
    
    public int top() {
        return ans.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}


//Using ArrayList
class MinStack {

    ArrayList<Integer> ans;
    ArrayList<Integer> min;
    public MinStack() {
        ans=new ArrayList<>();
        min=new ArrayList<>();
    }
    
    public void push(int x) {
        ans.add(x);
        if(min.size()==0)
            min.add(x);
        else
            min.add(Math.min(min.get(min.size()-1),x));
    }
    
    public void pop() {
        ans.remove(ans.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {
        return ans.get(ans.size()-1);
    }
    
    public int getMin() {
        return min.get(ans.size()-1);
    }
}

