https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/


/*
General For any binary tree
*/
class Tree
{
    int minValue(Node node)
    {
        if(node==null)
          return Integer.MAX_VALUE;
        return Math.min(node.data,Math.min(minValue(node.left),minValue(node.right)));
    }
}

/*
For binary search-tree
Use property that lowest elemnt will be in left subtree
we will iterate to left subtree recursively to left only
*/

class Tree
{
    int minValue(Node node)
    {
        Node curr=node;
        while(curr.left!=null)
          curr=curr.left;
        return curr.data;
    }
}