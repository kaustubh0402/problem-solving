/*
Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get them. But Penelope has magical powers that can build bridges across the dangerous river and take her friends to safety. The only bridges that can withstand the Devil's wrath are the ones built between two similar trees in the forest. 
Given str1 and str2 denoting the order of trees on either side of the river, find the maximum number of bridges that Penelope can build and save everyone from the Devil. 
Note: Each tree in the forest belongs to one of the 3 categories represented by * or # or @

Example 1:

Input:
str1 = "*@#*" 
str2 = "*#"
Output:
2
Explanation:
str1 = "*@#*" and str2 = "*#" 
Two bridges can be built between the banks 
of the river in the following manner. 
* @ # *
|      |
*     #
Example 2:

Input:
str1 = "***"
str2 = "##"
Output:
0

*/

//Basically longest common subsequence
class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
        int n1 = str1.length();
        int n2 = str2.length();
        int dp[][] = new int[n1+1][n2+1];
        
        for(int i=1;i<=n1;i++)
        {
            dp[i][0] = 0;
        }
        
        for(int j=0;j<=n2;j++){
        dp[0][j] = 0;
        }
        
        for(int i = 1;i<=n1;i++) {
        for(int j=1;j<=n2;j++) {
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
        dp[i][j] = dp[i-1][j-1] + 1;
        }else if(dp[i-1][j] >= dp[i][j-1]) {
        dp[i][j] = dp[i-1][j];
        }else {
        dp[i][j] = dp[i][j-1];
        }
        }
        }
        return dp[n1][n2];
    }
}