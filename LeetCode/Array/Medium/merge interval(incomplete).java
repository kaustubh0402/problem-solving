class Solution {
    public int[][] merge(int[][] intervals) {
        int mark[]=new int[1002];
        int ans[][]=new int[intervals.length][2];
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]==intervals[i][1])
            {
                mark[intervals[i][0]]++;
                continue;
            }
            mark[intervals[i][0]]++;
            mark[intervals[i][1]]--;
        }
        for(int i=1;i<1001;i++)
        {
            mark[i]=mark[i-1]+mark[i];
        }
        int start=0;
        int count=0;
        for(int i=0;i<1001;i++)
        {
            while(i<1001 && mark[i]==0)
            {
                i++;
            }
            if(i==1001)
                continue;
            start=i;
            while(i<1001 && mark[i]!=0)
            {
                i++;
            }
            ans[count][0]=start;
            ans[count][1]=i;
            count++;
        }
        int answer[][]=new int[count][2];
        for(int i=0;i<answer.length;i++)
        {
            answer[i][0]=ans[i][0];
            answer[i][1]=ans[i][1];
        }
        return answer;
    }
}