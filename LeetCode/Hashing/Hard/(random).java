int getPowerCouple2021(int n, int e, int[] from, int[] to, int[] w) {
    HashMap<Integer,TreeSet<Integer>> h=new HashMap<>();
    for(int i=0;i<e;i++)
    {
        if(!h.containsKey(w[i]))
          h.put(w[i],new TreeSet<Integer>());
        else
        {
          h.get(w[i]).add(from[i]);
          h.get(w[i]).add(to[i]);
        }
    }
    int ans=-1;
    HashMap<Integer,Integer> hm=new HashMap<>();
    ArrayList<Integer> temp=new ArrayList<>();
    for(int i=0;i<h.size();i++)
    {
        temp=new ArrayList<Integer>();
        temp.addAll(h.get(i));
        for(int j=0;j<temp.size();j++)
        {
            int key=temp.get(j)*10;
            for(int k=j+1;k<temp.size();k++)
            {
                key+=temp.get(k);
                hm.put(key,hm.getOrDefault(key,0)+1);
            }
        }
    }
    int mx=-1;
    for(Integer val:hm.keySet())
    {
        if(mx<=val)
        {
            int key=hm.get(val);
            int check=(key%10)*(key/10);
            if(ans<check)
            {
                ans=check;
            }
        }
    }
    return ans;
}
