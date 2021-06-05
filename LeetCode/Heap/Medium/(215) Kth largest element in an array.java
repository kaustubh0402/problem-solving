https://leetcode.com/problems/kth-largest-element-in-an-array/
//problem no : 215

class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i=(nums.length-2)/2;i>=0;i--)
          heapify(i,nums,nums.length);
        for(int i=0;i<k-1;i++)
            extract_min(nums,nums.length-i);
        return extract_min(nums,nums.length-k+1);
    }
      
   void heapify(int index,int a[],int n)
   {
       int idx=index,lc=2*index+1,rc=lc+1;
       if(lc<n && a[idx]<=a[lc])
          idx=lc;
       if(rc<n && a[idx]<=a[rc])
          idx=rc;
       if(idx!=index)
       {
          int temp=a[idx];
          a[idx]=a[index];
          a[index]=temp;
          heapify(idx,a,n);
       }
       return;
   }
   
   
   int extract_min(int a[],int n)
   {
       int minm=a[0];
       a[0]=a[n-1];
       n--;
       heapify(0,a,n);
       return minm;
   }
   
}