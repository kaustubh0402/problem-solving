//https://leetcode.com/problems/making-file-names-unique/
//problem no 1487
/*
Explanation:
1) create hashmap for all given string containing in given list and integer
2) Integer is initially 1 which indicate version of that file
    it will increse if same version is found 
*/
//My solution
class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap <String,Integer> h=new HashMap <String,Integer>();
        for(int i=0;i<names.length;i++)
        {
            if(h.containsKey(names[i]))
            {
                int counter=h.get(names[i]);
                StringBuilder s=new StringBuilder(names[i]);
                s.append('(');
                s.append(counter);
                s.append(')');
                counter++;
                while(h.containsKey(s.toString()))
                {
                    s=new StringBuilder(names[i]); 
                    s.append('(');
                    s.append(counter);
                    s.append(')');
                    counter++;
                }
                h.put(s.toString(),1);
                h.put(names[i],counter);
                names[i]=s.toString();
            }
            else
            {
                h.put(names[i],1);
            }
        }
        return names;
    }
}
