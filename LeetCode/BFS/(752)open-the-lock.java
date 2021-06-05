//https://leetcode.com/problems/open-the-lock/discuss/1252173/JAVA-Commented-BFS-modular-code
/*
Leetcode hint:
We can think of this problem as a shortest path problem on a graph: there are `10000` nodes (strings `'0000'` to `'9999'`), and there is an edge between two nodes if they differ in one digit, that digit differs by 1 (wrapping around, so `'0'` and `'9'` differ by 1), and if *both* nodes are not in `deadends`.
*/
class Solution {
    public int openLock(String[] deadends, String target) {
        //HashSet is for visited nodes between 0000 to 9999 nodes of graph
        HashSet<String> vis =new HashSet<>();
        
        //Now we know that deadends cannot reached so 
        //we will add it to already visited so they cannot be visited again
        //Basically deadends acts as visited nodes.
        for(String current: deadends)
            vis.add(current);
        
        
        //Base condition
        if(vis.contains(target) || vis.contains("0000"))
            return -1;
        
        //Intialize queue for BFS
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int level=0;
        
        
        //BFS start
        while(!q.isEmpty())
        {
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                String current=q.poll();
                if(current.equals(target))
                    return level;
                
                //Check conditions for next generated string
                for(String val:nextString(current))
                {
                    // System.out.println(val);
                    if(!vis.contains(val)) 
                    {
                        q.offer(val);
                        vis.add(val);
                    }
                } 
            }
            level++;
        }
        //If target is not achievable
        return -1;
    }
    
    //Generate next possible strings according to condition
    Set<String> nextString(String s)
    {
        Set<String> next=new HashSet<>();
        char a[]=s.toCharArray();
        for(int i=0;i<4;i++)
        {
            char curr=a[i];
            //clockwise
            a[i]=curr=='9'?'0':(char)(curr+1);
            next.add(new String(a));
            a[i]=curr; //Return string to original state
            
            //anti clockwise
            a[i]=curr=='0'?'9':(char)(curr-1);
            next.add(new String(a));
            a[i]=curr; //Return string to original state
        }
        return next;
    }
}