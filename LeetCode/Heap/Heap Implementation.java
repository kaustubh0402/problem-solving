   void build(int a[],int n)
   {
       for(int i=(n-2)/2;i>=0;i--)
          heapify(i,a,n);
   }
   
   
   void heapify(int index,int a[],int n)
   {
       int idx=index,lc=2*index+1,rc=lc+1;
       if(lc<n && a[idx]>a[lc])
          idx=lc;
       if(rc<n && a[idx]>a[rc])
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
   
   int find_min(int a[],int n)
   {
	   int min_element=a[0];
	   return min_element;
   }
   