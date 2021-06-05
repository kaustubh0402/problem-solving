https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//Problem no : 230

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 
 //Iterative code
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty())
        {
            while(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            if(--k==0)
                return curr.val;
            curr=curr.right;
        }
        return -1;
    }
}

//Recursive code
class Solution {
    int small;
    int sm=0;
    public int kthSmallest(TreeNode root, int k) {
        sm=k;
        helper(root);
        return small;
    }
    
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        helper(root.left);
        sm--;
        if(sm==0)
        {
            small=root.val;
            return ;
        }
        helper(root.right);
    }
}