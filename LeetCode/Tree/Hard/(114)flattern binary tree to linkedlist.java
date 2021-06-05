https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Problem no : 114

/*
Read about morris traversal( constant space tree traversal)
    1
  2   5
 3 4   6 
 
Consider above tree:
We will travel for each root
  We will check if left of root exist or not
    if not exist then continue for next iteration
	if exist
	  we will find right most pointer of that node
	  and connect above node to right of root
	  and change root.right=root.left
	
       1
	 2   5
    3 4   6 

root=1
root.left=2 (exist)
root.right=5
rightmost part of root.left=4
connect 4 to 5(root.right)
change root.right=root.left and set root.left=null

        1
	     2
		3 4
		   5
            6


Now root =2
root.left=3(exist)
root.right=4
right most of root.left(3)=3 (no rightmost element)

connect 3 to root.right(4)

        1
	     2
		  3
		   4
		    5
             6
			 
Now root=3
root.left==not exist (continue)

Now root=4
root.left=not exist (continue)

do above till root==null
 
 */
 
 
class Solution {
    public void flatten(TreeNode root) {
        while(root!=null)
        {
            if(root.left==null)
            {
                root=root.right;
                continue;
            }
            TreeNode temp=root.left;
            while(temp.right!=null)
            {
                temp=temp.right;
            }
            temp.right=root.right;
            root.right=root.left;
            root.left=null;
            root=root.right;
        }
    }
}

//Recursive solution

/*

  1 
 / \ 
3  4  
Let's see what is happening with this code.

Node(4).right = None
Node(4).left = None
prev = Node(4)

Node(3).right = Node(4) (prev)
Node(3).left = None
prev = Node(3)->Node(4)
    1
   /
  3
   \
    4

Node(1).right = prev = Node(3) -> Node(4)
Node(1).left = None
prev = Node(1)->Node(3)->Node(4) (Which is the answer)
1
 \
  3
   \
    4

The answer use self.prev to recode the ordered tree of the right part of current node.
Remove the left part of current node
*/

class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)
            return ;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}

