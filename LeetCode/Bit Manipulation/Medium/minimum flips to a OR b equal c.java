class Solution {
    public int minFlips(int a, int b, int c) {
        int ans=0;
        int or=a | b;
        for(int i=0;i<32;i++)
        {
            int inctwo=(c>>i)&1;
            int incone=(or>>i)&1;
            if((incone)!=(inctwo))
            {
                if(inctwo==0)
                {
                    ans=(a>>i)^1;
                    ans=(b>>i)^1;
                }
                else
                    ans++;
            }
        }
        return ans;
    }
}