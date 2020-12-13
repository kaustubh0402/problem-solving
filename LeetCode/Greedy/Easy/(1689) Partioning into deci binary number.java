https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
//Problem no : 1689

class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++)
        {
            if(n.charAt(i)-48>max)
                max=n.charAt(i)-48;
        }
        return max;
    }
}