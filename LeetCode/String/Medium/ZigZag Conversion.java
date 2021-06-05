//https://leetcode.com/problems/zigzag-conversion/
//problem no 6. 

class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==0)
            return "";
        if(numRows==1)
            return s;
        StringBuffer ans=new StringBuffer();
        ArrayList<ArrayList<Character>> l=new ArrayList<ArrayList<Character>>();
        int divi=2*numRows-2;
        for(int j=0;j<numRows;j++)
        {
            l.add(new ArrayList<Character>());
        }
        int p=0;
        for(int i=0;i<s.length()/divi;i++)
        {
            for(int j=0;j<numRows;j++)
            {
                l.get(j).add(s.charAt(p));
                p++;
            }
            for(int j=numRows-2;j>=1;j--)
            {
                l.get(j).add(s.charAt(p));
                p++;
            }
        }
        if(s.length()%divi>numRows)
        {
            for(int j=0;j<numRows;j++)
            {
                l.get(j).add(s.charAt(p));
                p++;
            }
            for(int j=numRows-2;j>2*numRows-2-s.length()%divi;j--)
            {
                l.get(j).add(s.charAt(p));
                p++;
            }
            
        }
        else
        {
        for(int i=0;i<s.length()%divi;i++)
        {
            l.get(i).add(s.charAt(p));
            p++;
        }
        }
        for(ArrayList<Character> t:l)
        {
            for(Character temp:t)
            {
                ans.append(temp);
            }
        }
        return  ans.toString();
    }
}

/*
LeetCode Solution
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}*/