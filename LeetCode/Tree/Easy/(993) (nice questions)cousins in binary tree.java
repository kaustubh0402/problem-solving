https://leetcode.com/problems/cousins-in-binary-tree/
//Problem no : 993


class Solution {
    TreeNode xpar=null;
    TreeNode ypar=null;
    int xx=-1,yy=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        valid(root,0,x,y);
        if(xpar!=ypar && xx==yy && xx!=-1)
            return true;
        return false;
    }
    
    public void valid(TreeNode root,int k,int x,int y)
    {
        if(root==null)
            return;
        if(root.val==x)
            xx=k;
        if(root.val==y)
            yy=k;
        if((root.left!=null && root.left.val==x) || (root.right!=null && root.right.val==x))
        {
            xpar=root;
        }
        if((root.left!=null && root.left.val==y) || (root.right!=null && root.right.val==y))
        {
            ypar=root;
        }
        valid(root.left,k+1,x,y);
        valid(root.right,k+1,x,y);
    }
}