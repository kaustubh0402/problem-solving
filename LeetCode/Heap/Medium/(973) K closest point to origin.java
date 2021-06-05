https://leetcode.com/problems/k-closest-points-to-origin/
//Problem no : 973


/*
Efiicient solution:
Using heap : KLog(N)
See Kth top elelmt solution or implementation of heap
*/


//Using min heap or Sorting(Nlogn)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b) ->{
            int sqr1=a[0]*a[0]+a[1]*a[1];
            int sqr2=b[0]*b[0]+b[1]*b[1];
            if(sqr1>sqr2)
                return 1;
            return -1;
        });
        for(int i=0;i<points.length;i++)
            q.offer(points[i]);
        int ans[][]=new int[k][2];
        int i=0;
        while(i<k)
        {
            ans[i]=q.poll();
            i++;
        }
        return ans;
    }
}

//Sorting solution
public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    return Arrays.copyOfRange(points, 0, K);
}



//Max heap Solution : NLog(k)
//We will just maintain heap of k min elemnts


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b) ->{
            int sqr1=a[0]*a[0]+a[1]*a[1];
            int sqr2=b[0]*b[0]+b[1]*b[1];
            if(sqr1<sqr2)
                return 1;
            return -1;
        });
        for(int i=0;i<k;i++)
            q.offer(points[i]);
        int ans[][]=new int[k][2];
        for(int i=k;i<points.length;i++)
        {
            q.offer(points[i]);
            q.poll();
        }
        int i=0;
        while(!q.isEmpty())
        {
            ans[i]=q.poll();
            i++;
        }
        return ans;
    }
}
