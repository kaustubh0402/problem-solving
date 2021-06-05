https://leetcode.com/problems/minimum-depth-of-binary-tree/
https://www.interviewbit.com/problems/min-depth-of-binary-tree/
//Problem no : 111

/*
Explanation:
Explanation:
It is same as maximum height in Binary tree
But we have to take care 1 extra corner case
Suppose if there is no left root then we can not take left height as 0
similarly if there is no right root then we can not take right height as 0
So  we will check if right height or left height is equal to 0 or not
if it is equal to zero then we will ignore it
i.e if left height is 0 then we should return right height
if above condition is not there then it will return 0 which is wrong
consider following example
           1
			  2 
				  3
					  4
						  5
In above tree min height is 5 not 0
as there are no left nodes hence 0 should not be height
*/

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
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return (right==0 || left==0)?(left+right+1):Math.min(right,left)+1;
    }
}