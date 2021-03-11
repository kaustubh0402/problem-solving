https://practice.geeksforgeeks.org/problems/maximum-distinct-elements-after-removing-k-elements5906/1#

//Similar or relative harder version of distribute candies leetcode 575 question
/*
Explanation:
As we required maximum distinct-elements so first we have to get rid of duplicate elements
Now we will store number and frequency in hashmap
Now there are two cases:
case 1:
  we have enough number of duplicates for given k
  i.e k should be smaller and equal to duplicate elements
  how to find duplicate elements?
  duplicate elements=total elements - distinct-elements
  duplicate elements=n- size of hashmap
Case 2:
  K is bigger than all duplicate elements
  now we anyhow make k completely exhausted i.e. k==0
  hence we have to delete distinct-elements also
  simple we will delete total elements-K
*/ 

class Complete{
    
  
    int maxDistinctNum(int a[], int n, int K)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int num:a)
          h.put(num,h.getOrDefault(num,0)+1);
        int hsize=h.size();
        if(K<=(n-hsize))
          return hsize;
        return n-K;
    }
  
    
}