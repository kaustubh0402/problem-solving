https://www.geeksforgeeks.org/policemen-catch-thieves/

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        int ans=0;
        ArrayList<Integer> police=new ArrayList<>();
        ArrayList<Integer> th=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]=='T')
              th.add(i);
            else
              police.add(i);
        }
        int l=0,r=0;
        while(l<police.size() && r<th.size())
        {
            if(Math.abs(th.get(r)-police.get(l))<=k)
            {
                ans++;
                l++;
                r++;
            }
            else if(th.get(r)<police.get(l))
              r++;
            else
              l++;
        }
        return ans;
	} 
} 