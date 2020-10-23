https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
//problem no: 1318

/*
Explanation:
1) find OR of a,b let say orvalue=a|b;
2)Now we Have to compare result of orvalue with given c
3)Iterate for 32 times(32 bit int in java)
4)There are two case if mismatch is found 
  1.if in given c bit is 1 and orvalue has bit 0
    for above case we need to change bit of orvalue to 1
	we don't care about which number among a,b to set 1 
	but we know that if bit of either one bit is set 1 then orvalue bit will be 1
	basically we have to change bit of one number only (OR logic property)
	then ans will be increment by 1
  2.if given c bit is 0 and orvalue has bit 1
    In above there are two possibilities
	  a)If bit of both a and b are set so we have to unset both bits to change orvalue to 0
	    so we will increase ans by 2
	  b)If bit of either bit is set so we have to change only one bit(among a,b) to 0 
	    as other number bit is already 0 
		so we will increase ans by 1.
5)if mismatch not found do nothing.
*/
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
                    ans+=((a>>i)&1)^0;
                    ans+=((b>>i)&1)^0;
					//Instaed of above two statements you can use following:
					//Read explanation point 4.2
					/*
					if( ((a>>i)&1) == 1)
						ans++;
					if( ((b>>i)&1) == 1)
						ans++;
					*/
                }
                else
                    ans++;
            }
        }
        return ans;
    }
}