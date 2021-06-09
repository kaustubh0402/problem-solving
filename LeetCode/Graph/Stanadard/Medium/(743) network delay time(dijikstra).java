//problem no : 743
https://leetcode.com/problems/network-delay-time/

//Here we will not require visited Array
//Graph given is directed 
//so node will not visit again and again

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adjacency List of graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        //distance vector for shortest distance
        //dist[i]=shortest distance from node i from source k
        int dist[]=new int[n+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        //Distance of source vertex to source vertex is always zero
        dist[k]=0;
        
        //Create adjacency list of graph from given input
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++)
        {
            int st=times[i][0];
            int end=times[i][1];
            int wt=times[i][2];
            
            adj.get(st).add(new ArrayList(Arrays.asList(end,wt)));
        }
        //adjacency list generation completed
        
        //we will use priority Queue to use Dijsktra algorithm
        //int[] int priority queue={a,b}=> {vertex,time from source till vertex}
        //we will sort on basis of time 
        PriorityQueue<int[]>q= new PriorityQueue<>((a,b)->(a[1]-b[1]));
        //insert spurce as starting in queue
        q.offer(new int[]{k,0});
        
        while(!q.isEmpty())
        {
            int curr[]=q.poll();
            //current vertex
            int vert=curr[0];
            //distance or weight till above point
            int wt=curr[1];
            
            //following loop will iterate over all adjacent nodes of current node
            for(int i=0;i<adj.get(vert).size();i++)
            {
                //possible adjacent vertex and weight/distance(here time)
                int poss_vert=adj.get(vert).get(i).get(0);
                int poss_wt=adj.get(vert).get(i).get(1);
                
                //suppose if distance of possible adjacent node is less than
                //weight of cuurent node+ edge between current node and adjacent node
                //so we will update dist of adjacent node as we have minimum
                if((dist[poss_vert]>wt+poss_wt))
                {
                    dist[poss_vert]=wt+poss_wt;
                    //push adjacent vertex in queue
                    q.offer(new int[]{poss_vert,dist[poss_vert]});
                }
            }
        }
        
        //as we know time is moving simulataneoulsy
        //hence we require maxiumum time(distance) among nodes 
        int ans=-1;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}