Geeks for geeks /Rearrange gievn array in place
/*
Explanation:
It is just like modifying given array in some form (like negation or mod) and use result simultaneously.

The array elements of the given array lies from 0 to n-1. 
Now an array element is needed that can store two different values at the same time. 
To achieve this increment every element at ith index is incremented by (arr[arr[i]] % n)*n.
After the increment operation of first step, every element holds both old values and new values.
 Old value can be obtained by arr[i]%n and a new value can be obtained by arr[i]/n
 
 
 
Let’s assume an element is a and another element is b, 
both the elements are less than n. So if an element a is incremented by b*n. 
So the element becomes a + b*n so when a + b*n is divided by n then the value is b 
and a + b*n % n is a.

Algorithm:  

Traverse the array from start to end.
For every index increment the element by array[array[index] ] % n. To get the ith element find the modulo with n, i.e array[index]%n.
Again Travsese the array from start to end
Print the ith element after dividing the ith element by n, i.e. array[i]/n.


*/


//User function Template for Java
class Solution 
{ 
    void prank(long[] a, int n)  
    { 
        for(int i=0;i<n;i++)
        {
            a[i]=a[i]+(a[(int)a[i]]%n)*n;
        }
        for(int i=0;i<n;i++)
        {
            a[i]=a[i]/n;
        }
    }
} 