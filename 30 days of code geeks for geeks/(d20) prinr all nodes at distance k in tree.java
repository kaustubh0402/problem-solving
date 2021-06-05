Print all nodes at distance K

/*
There are two methods:
watch youtube
*/


class Solution{
    Node start=null;
    int sum_at_distK(Node root, int target, int k){
        int sum=0;
        HashMap<Node,Node> h=new HashMap<>();
        HashSet<Node> visited=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        parentchild(root,h,target);
        if(start!=null)
        q.offer(start);
        while(!q.isEmpty())
        {
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                Node curr=q.poll();
                visited.add(curr);
                if(k>=0)
                  sum+=curr.data;
                if(h.get(curr)!=null && !visited.contains(h.get(curr)))
                    q.offer(h.get(curr));
                if(curr.left!=null && !visited.contains(curr.left))
                    q.offer(curr.left);
                if(curr.right!=null && !visited.contains(curr.right))
                    q.offer(curr.right);
            }
            k--;
            if(k<0)
              return sum;
        }
        return sum;
    }
    
    public void parentchild(Node root,HashMap<Node,Node> h,int target)
    {
        if(root==null)
          return;
        if(root.left!=null)
          h.put(root.left,root);
        if(root.right!=null)
          h.put(root.right,root);
        if(root.data==target)
          start=root;
        parentchild(root.left,h,target);
        parentchild(root.right,h,target);
    }
}