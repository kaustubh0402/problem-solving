https://leetcode.com/problems/maximum-frequency-stack/
//Problem no : 895


/*
Explanation
General Idea:
At every Instant(call)  we required most frequqnt element
So we have to change frequqncy at every call
So we required HashMap(h) which store frequency of element 
Not that we have to update hashmap(h) after every call(push and pop)

Now We have to maintain top frequqncy of elements
We can use TreeMap <frequqncy ,stack>
TreeMap will be frequqncy and stack of  elements of corresponding frequency
Suppose if we have 5 as element and frquency of 2 then it will be present in stack at key 2 in treemap
Now if new elemnt 5 have to push
then we will increase frequency of 5 in hashmap(h)
and push 5 in stack of tree map at key 3(already freq was 2 + 1)

Now for pop
we have to access max frequqncy and treemap store values according to accesnding order of key 
Now last element in treemap will be Highest frequency
So we will pop element from stack at last posnof treemap
Note that we will also remove key at last if stack at that key become empty
*/


class FreqStack {
    TreeMap<Integer,Stack<Integer>> tm;
    HashMap<Integer,Integer> h;
    public FreqStack() {
        tm=new TreeMap<>();
        h=new HashMap<>();
    }
    
    public void push(int x) {
        int freq=h.getOrDefault(x,0)+1;
        h.put(x,freq);
        if(!tm.containsKey(freq))
            tm.put(freq,new Stack<>());
        tm.get(freq).push(x);
    }
    
    public int pop() {
        int last_key=tm.lastKey();
        int val=tm.get(last_key).pop();
        h.put(val,last_key-1);
        if(tm.get(last_key).size()==0)
            tm.remove(last_key);
        return val;
    }
}




//We can use HashMap and varible maxfrequency instead of treemap for efficient aprroaxh

class FreqStack {
    HashMap<Integer,Stack<Integer>> tm;
    HashMap<Integer,Integer> h;
    int max_freq=-1;
    public FreqStack() {
        tm=new HashMap<>();
        h=new HashMap<>();
    }
    
    public void push(int x) {
        int freq=h.getOrDefault(x,0)+1;
        h.put(x,freq);
        if(!tm.containsKey(freq))
            tm.put(freq,new Stack<>());
        tm.get(freq).push(x);
        if(max_freq<=freq)
            max_freq=freq;
    }
    
    public int pop() {
        int val=tm.get(max_freq).pop();
        h.put(val,max_freq-1);
        if(tm.get(max_freq).size()==0)
            max_freq--;
        return val;
    }
}
