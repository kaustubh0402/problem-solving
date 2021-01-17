https://leetcode.com/problems/count-sorted-vowel-strings/
//Problem no : 1641

/*
Explanation:
 Think like we can find solution of n=2 from n=1...
 we can calculate n value from n-1
 
 we will calculate string starting from a,e,i,o,u separately
 and store value of current count of string starting with a,e,i,o,u for next iteration
 consider for n=3
   here suppose we have result of n-1 i.e n=2
   i.e count of string starting with a,e,i,o,u for n=2 already
   
   
 for n=1 answer will be 5 ['a','e','i','o','u']
 for n=2
   consider for 'a' answer will be ['aa','ae','ai','ao','au'] for a, ans=5;
   consider for 'e' answer will be ['ee','ei','eo','eu']      for e, ans=4;
   consider for 'i' answer will be ['ii','io','iu']           for i, ans=3;
   consider for 'o' answer will be ['oo','ou']                for o, ans=2;
   consider for 'u' answer will be ['uu']                     for u, ans=1;
   total ans=15
   from above we can note obswervation
   for a, all values from previous n-1 will be used 
   for e, all values from previous n-1 except 'a' 
     as e is lexiographically bigger than 'a' so string of 'a' in n-1 will not be consider for e
   for i, all values from previous n-1 except 'a' and 'e'
     as i is bigger than 'a' and 'e' 
   similarly for 'o' and 'u'

for n=3
   previous iteration n-1=(3-1)=2
   for n=2 : a=5,e=4,i=3,o=2,u=1;
   total sum=15;
now for n=3:
   a=(all strings in (n-1) i.e total sum )=15
   b=(all strings in (n-1) except a )=15-5=10
   and so on
   .
   .
   .   
*/


class Solution {
    public int countVowelStrings(int n) {
        int a=1,e=1,i=1,o=1,u=1;
        int sum=0;
        for(int index=0;index<n;index++)
        {
            sum=a+e+i+o+u;
            int temp=sum;
            u=temp-o-i-e-a;
            o=u+o;
            i=o+i;
            e=i+e;
            a=e+a;
        }
        return sum;
    }
}
