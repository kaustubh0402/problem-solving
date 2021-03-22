https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//Problem no : 589


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node(int v) {
        val = v;
    }
    public Node(int v, List<Node> child) {
        val = v;
        children = child;
    }
}
*/

/*
Recursive solution is similar to normal preorder of binary tree
only difference is while pushing childern instead of left and right 
we are pushing all nodes in children arraylist of parent
*/

class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null)
            return ans;
        ans.add(root.val);
        for(int i=0;i<root.children.size();i++)
        {
            preorder(root.children.get(i));
        }
        return ans;
    }
}

/*
For Iterartive version of pre order:
We are maintaining stack. so we have to consider stack is LIFO(last in first out)
As we know Pre order is VLR (print vertex -left call -right call) in binary tree
so in pre order we print data then push right first and then push left
This ensures that left which is top stack execute first and right below in stack execute later

Similarly here we have childern in form of arraylist 
so we will push arraylist from end to start 
so start elemnt which is at top execuet first and maintains pre order

*/

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList <Integer> ans =new ArrayList<>();
        Stack <Node> data=new Stack <Node>();
        if(root!=null)
            data.push(root);
        while(!data.isEmpty())
        {
            Node curr=data.pop();
            int len=curr.children.size();
            ans.add(curr.val);
            for(int i=len-1;i>=0;i--)
                data.push(curr.children.get(i));
        }
        return ans;
    }
}


