https://leetcode.com/problems/beautiful-arrangement/
//Problem no : 526


Similar problem as permutation of array
Only we have to check one condition given in question
We can find permutation and check condition later
But it will give TLE

As we know that if arr[i]%i==0 or i%arr[i] fails
then it is failure for complete permutation
so we will check above condition before calling function



//TLE Solution
class Solution {
    int ans=0;
    public int countArrangement(int n) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=n;i++)
            a.add(i);
        helper(a,n,0);
        return ans;
    }
    
    void helper(ArrayList<Integer> a,int n,int index)
    {
        if(index==n)
        {
            ans+=(check(a));
            return;
        }
        for(int i=index;i<n;i++)
        {
            int temp=a.get(i);
            a.set(i,a.get(index));
            a.set(index,temp);
            helper(a,n,index+1);
            temp=a.get(i);
            a.set(i,a.get(index));
            a.set(index,temp);
        }
    }
    
    int check(ArrayList<Integer> a)
    {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)%(i+1)!=0 && (i+1)%a.get(i)!=0)
                return 0;
        }
        return 1;
    }
}



class Solution {
    int ans=0;
    public int countArrangement(int n) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=n;i++)
            a.add(i);
        helper(a,n,0);
        return ans;
    }
    
    void helper(ArrayList<Integer> a,int n,int index)
    {
        if(index==n)
        {
            ans++;
            return;
        }
        for(int i=index;i<n;i++)
        {
            int temp=a.get(i);
            a.set(i,a.get(index));
            a.set(index,temp);
            if(a.get(index)%(index+1)==0 || (index+1)%a.get(index)==0)
              helper(a,n,index+1);
            temp=a.get(i);
            a.set(i,a.get(index));
            a.set(index,temp);
        }
    }
}
