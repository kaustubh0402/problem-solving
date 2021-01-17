https://leetcode.com/problems/count-sorted-vowel-strings/
//Problem no : 1641

/*
Explanation:
 Think like we can find solution of n=2 from n=1...i.e. using dp
 we can calculate n value from n-1
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
   a=(all strings in (n-1)   
*/
class Solution {
    public int countVowelStrings(int n) {
        int a=1,b=1,c=1,d=1,e=1;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=a+b+c+d+e;
            int temp=sum;
            e=temp-d-c-b-a;
            d=e+d;
            c=d+c;
            b=c+b;
            a=b+a;
        }
        return sum;
    }
}
