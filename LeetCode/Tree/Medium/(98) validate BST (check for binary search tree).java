https://leetcode.com/problems/validate-binary-search-tree/
https://practice.geeksforgeeks.org/problems/check-for-bst/1
//Problem no : 98


/*
Explanation:
We have used BST Inorder Property
In inorder traversal of BST we will get output in sorted way
We will do inorder traversal of Given Tree and store result in array
If Elements in array are incresing(sorted) then given tree is BST
else it is not

Note: We can maintain previous node so that we can avoid extra space used by array
*/


class Solution {
    ArrayList<Integer> store=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        helper(root);
        for(int i=1;i<store.size();i++)
        {
            if(store.get(i-1)>=store.get(i))
                return false;
        }
        return true;
    }
    
    public void helper(TreeNode root)
    {
        if(root!=null)
        {
            helper(root.left);
            store.add(root.val);
            helper(root.right);
        }
    }
}



/*
Explanation:
We will maintain range for every node
Let suppose node range in [min,Max]
Now According to BST property Left elemnt should be less than root
So we will update max value of current node with previous node value
why?? as we are going to left then value should be less that root
i.e max value should be root value
Similarly we will update min value for current node as root node if we call right
We will check root value should be in min and max range for every call
*/


class Solution {
    public boolean isValidBST(TreeNode root) {
        long a=-2147483649l;
        long b=2147483648l;
        return helper(root,a,b);
    }
    
    public boolean helper(TreeNode root,long min,long max)
    {
        boolean right=true,left=true;
        if(root!=null)
        {
            if(root.val<=min || root.val>=max)
                return false;
            left=helper(root.left,min,root.val);
            right=helper(root.right,root.val,max);
        }
        return (right&left);
    }
}