https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
//problem no: 1647

/*
Solution 1:
* First Count frequency of each char in string using frequency arrya (or HashMap).
* Now We will maintain HashSet for every frequency occurs in string except 0
* Suppose if frequency of current character is not present in hashset  simply we push it in hashset
  In above case we need not to delete in char as frequency of that char is already unique
* Else we have to delete char as frequency of current char is not unique let say f[i]
  for above process follow:
  1.  increment our final answer
  2. we will check whether f[i]-1 present in hashset or not 
     if  not present then freq is unique and push that freq in hashset
     else
     we will check for f[i]-2 and do above process continuosly till we found unique freq or freq=0
return ans
*/

class Solution {
    public int minDeletions(String s) {
        int f[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            f[s.charAt(i)-'a']++;
        }
        int ans=0;
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<26;i++)
        {
            if(f[i]!=0)
            {
                if(h.contains(f[i]))
                {
                    while(h.contains(f[i]))
                    {
                        f[i]--;
                        ans++;
                    }
                }
                if(f[i]!=0)
                   h.add(f[i]);
            }
        }
        return ans;
    }
}


/*
Sorting frequency array
In this we are conisdering highest frequency as unique first
Now we will start from highest frequency to lowest
let say highest freq is 100...Now intial unique freq will 100
We will decrement unique freq after each iteration so that it will be unique always
Suppose there is repetition of frequency for second iteration, 
  Now our unique freq is 99 and actual freq of current char is 100
  Here we will add (100-99) i.e (f[i]-unique) to answer
else
  we will update our unique freq to f[i].
*/
class Solution {
    public int minDeletions(String s) {
        int f[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            f[s.charAt(i)-'a']++;
        }
        int ans=0;
        Arrays.sort(f);
        int unique_freq=f[25];
        for(int i=25;i>=0;i--)
        {
            if(f[i]!=0)
            {
                if(f[i]>unique_freq)
                {
                    ans+=(f[i]-unique_freq);
                }
                else
                {
                    unique_freq=f[i];
                }
            }
            if(unique_freq>0)
                unique_freq--;
        }
        return ans;
    }
}