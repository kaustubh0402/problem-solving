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


/*
Optimize: O(1) extra space (except one stack )
O(1) time

idea:
We required one stack
and one min varaible to store current elemnt

There are two cases:
1) push elemnt x is greater than current min
2) push elemnt x is smaller than current min

1) for case 1 min elemnt will not change so we will push elemnt x as it is
2) for case 2 min elemnt will change and min will be x 
   but we have to preserve currnet min i.e stored in min varibale
	 so we will store previous min in form of something in stack 
	 Now we will push x+x-min in stack and update min=x
	 in stack elemnt=2*x-min and new min=x
	 
Note : Observe carefully elements present in stack are not actual elemnts
It is same elemnt as input in stack if x (current elemnt) is grater than min
In case of x smaller than min modified value is pushed in stack

now how to retrive or pop()??

Again there are two cases:
One thin we have notice that if currnt top of stack is greater than min 
then we need not to worry about min as above elemnt is not contributing to min and of case 1 (read note)

In other case: now our min elemnt is top of stack (why?? beacuse in this condition we are changing actual elemnt while pushing in stack)
we have push let top=2*x-min;  i.e min=2*x-top
in stack we have top (top elemnt of stack)
we have store min=x while pushing 
so while poping we will change min=2*min (as min=x) -top

*/

class MinStack {

    Stack<Long> ans;
    long min=Integer.MAX_VALUE;
    public MinStack() {
        ans=new Stack<>();
    }
    
    public void push(int x) {
        if(ans.isEmpty())
        {
            ans.push((long)x);
            min=x;
        }
        else if(x>=min)
            ans.push((long)x);
        else
        {
            ans.push((long)x+x-min);
            min=x;
        }
    }
    
    public void pop() {
        if(ans.peek()>=min)
            ans.pop();
        else
        {
            min=min+min-ans.pop();
        }
    }
    
    public int top() {
        if(ans.peek()>min)
            return (int)(long)ans.peek();
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}
