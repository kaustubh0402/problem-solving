https://leetcode.com/problems/maximum-average-pass-ratio/
//Problem no : 1792


/*
Explanation:
Pay attention to how much the pass ratio changes when you add a student to the class. 
If you keep adding students,The more students you add to a class, the smaller the change in pass ratio becomes.

Since the change in the pass ratio is always decreasing with the more students you add, 
then the very first student you add to each class is the one that makes the biggest change in the pass ratio.

Because each class's pass ratio is weighted equally,
 it's always optimal to put the student in the class that makes the biggest change among all the other classes.
 
Keep a max heap of the current class sizes and order them by the change in pass ratio. 
For each extra student, take the top of the heap, update the class size, and put it back in the heap.
*/

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> q=new PriorityQueue<>((x,y)-> Double.compare(y[0],x[0]));
        int n=classes.length;
        double ans=0;
        for(int i=0;i<n;i++)
        {
            double num=classes[i][0];
            double deno=classes[i][1];
            double profit=((num+1)/(deno+1))-(num/deno);
            q.offer(new double[]{profit,num+1,deno+1});
            ans+=(num/deno);
        }
        
        while(extraStudents-- >0)
        {
            double curr[]=q.poll();
            ans+=curr[0];
            double numerator=curr[1];
            double denominator=curr[2];
            double future_profit=((numerator+1)/(denominator+1))-(numerator/denominator);
            q.offer(new double[]{future_profit,numerator+1,denominator+1});
        }
        return ans/n;
    }
}