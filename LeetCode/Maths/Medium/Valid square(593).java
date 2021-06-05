https://leetcode.com/problems/valid-square/
//Problem no: 593


class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashMap<Double,Integer> val=new HashMap<Double,Integer>();
        int pt[]=new int[8];
        for(int i=0;i<2;i++)
        {
            pt[i]=p1[i];
        }
        for(int i=2;i<4;i++)
        {
            pt[i]=p2[i-2];
        }
        for(int i=4;i<6;i++)
        {
            pt[i]=p3[i-4];
        }
        for(int i=6;i<8;i++)
        {
            pt[i]=p4[i-6];
        }
        for(int i=0;i<=6;i+=2)
        {
            for(int j=i+2;j<=6;j+=2)
            {
                double dist=Math.abs(Math.sqrt((pt[i]-pt[j])*(pt[i]-pt[j])+(pt[i+1]-pt[j+1])*(pt[i+1]-pt[j+1])));
                if(val.containsKey(dist))
                {
                    val.put(dist,val.get(dist)+1);
                }
                else
                {
                    val.put(dist,1);
                }
            }
        }
        int len1=2,len2=4;
        if(val.size()!=2)
            return false;
        else
        {
            for(Integer num:val.values())
            {
                if(num==len1)
                    len1=0;
                if(num==len2)
                    len2=0;
            }
        }
        if(len1!=0 || len2!=0)
            return false;
        return true;
    }
}






public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> s = new HashSet<>();
        if (isSame(p1,p2) || isSame(p1,p3) || isSame(p1,p4) || isSame(p2,p3) || isSame(p3,p4) || isSame(p2,p4)) {
            return false;
        } 
        s.add(dis(p1,p2));
        s.add(dis(p1,p3));
        s.add(dis(p1,p4));
        s.add(dis(p2,p3));
        s.add(dis(p2,p4));
        s.add(dis(p3,p4));
        
        return s.size() == 2;
    }
    
    private int dis(int[] p1, int[] p2) {
        return (p1[0]-p2[0]) * (p1[0]-p2[0]) + (p1[1]-p2[1]) * (p1[1]-p2[1]);
    }
    private boolean isSame(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }