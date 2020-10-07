//https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
//problem no: 1450

//Easy solution
public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; ++i) {
            res += startTime[i] <= queryTime && queryTime <= endTime[i] ? 1 : 0;
        }
        return res;        
    }

//Unnecessary different logic 
//solution 2
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int line[]=new int[1002];
        for(int i=0;i<startTime.length;i++)
        {
            line[startTime[i]]++;
            line[endTime[i]+1]--;
        }
        int ans=0;
        for(int i=1;i<=queryTime;i++)
        {
            ans+=line[i];
        }
        return ans;
    }
}