https://leetcode.com/problems/angle-between-hands-of-a-clock/
//Problem no : 1344

class Solution {
    public double angleClock(int hour, int minutes) {
        int degmin=6*minutes; // Angle between 12 and given minutes (as 1 minutes=6 degree)
        double diff=minutes/2.0; //Extra angle creted due to minutes hand ib hr hand
		int deghr=30*hour;    // Angle between 12 and given hour hand excluding extra( as 1 hr=30 degree)
        if(degmin-deghr>0)
            diff=-diff;
        double ans=Math.abs(degmin-deghr)+diff;
        if(ans>180)
            return 360-Math.abs(ans);
        return Math.abs(ans);
    }
}