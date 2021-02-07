https://www.geeksforgeeks.org/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree-set-2/

/*
Given Preorder, Inorder and Postorder traversals of some tree of size N. 
The task is to check if they are all of the same tree or not.

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
*/

/*
Idea: Make tree from inorder and preorder with help of helper function
and given post order array should match with post order traversal of tree made from above in post function

In helper function we are traversing each root in preorder 
and finding position in order so that particular range of inorder 

*/

public class Node{
    int val;
    Node left;
    Node right;
    public Node(int val)
    {
        this.val=val;
    }
}

class Solution
{
    public boolean checktree(int preorder[], int inorder[], int postorder[], int N)
    {
        Node root=helper(preorder,inorder,0,N-1);
        if(root==null)
          return false;
        return post(root,postorder);
    }
	
	
    int index=0;
    
	public Node helper(int preorder[],int inorder[],int start,int end)
    {
        if(start>end)
          return null;
        Node root=new Node(preorder[index++]);
        int pos=-1;
        for(int i=start;i<=end;i++)
        {
            if(inorder[i]==root.val)
            {
                pos=i;
                break;
            }
        }
        if(pos==-1)
          return null;
        root.left=helper(preorder,inorder,start,pos-1);
        root.right=helper(preorder,inorder,pos+1,end);
        return root;
    }
    
	
	int in=0;
    
	public boolean post(Node root,int postorder[])
    {
        if(root==null)
          return true;
        boolean left=post(root.left,postorder);
        boolean right=post(root.right,postorder);
        if(root.val!=postorder[in++])
          return false;
        return (left&right);
    }
}



