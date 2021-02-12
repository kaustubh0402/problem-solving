/*
Inorder and preorder to postorder 
output in array (no need to make tree)
*/

class GfG
{
    int index=0;
    HashMap<Integer,Integer> h=new HashMap<>();
	void printPostOrder(int in[], int pre[], int n)
	{
	    for(int i=0;i<n;i++)
	      h.put(in[i],i);
		helper(in,pre,0,n-1);
	}
	void helper(int in[],int pre[],int start,int end)
	{
	    if(start>end)
	      return;
	    int pos=h.get(pre[index++]);
	    helper(in,pre,start,pos-1); //L
	    helper(in,pre,pos+1,end);  //R
	    System.out.print(in[pos]+" ");//V
	}
}