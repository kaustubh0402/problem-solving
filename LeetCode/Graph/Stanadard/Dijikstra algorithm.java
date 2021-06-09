//refer network delay proble from leetcode problem no. 743 for commented code explanation
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        //distance vector for shortest distance
        //dist[i]=shortest distance from node i from source k
        int dist[]=new int[v];

        //Visited array as it is undirected graph 
        //In directed graph nodes can revisit again
        boolean vis[]=new boolean[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        //Distance of source vertex to source vertex is always zero
        dist[s]=0;
        

        //we will use priority Queue to use Dijsktra algorithm
        //int[] int priority queue={a,b}=> {vertex,time from source till vertex}
        //we will sort on basis of time
        PriorityQueue<int[]>q= new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.offer(new int[]{s,0});
        
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            //current vertex
            int vert=curr[0];
            //distance or weight till above point
            int distance=curr[1];
            //mark visited vertex as true
            vis[vert]=true;
            
            //following loop will iterate over all adjacent nodes of current node
            for(int i=0;i<adj.get(vert).size();i++)
            {
                //possible adjacent vertex and weight/distance
                int poss_w=adj.get(vert).get(i).get(0);
                int wt=adj.get(vert).get(i).get(1);

                //suppose if distance of possible adjacent node is less than
                //weight of cuurent node+ edge between current node and adjacent node
                //so we will update dist of adjacent node as we have minimum
                if(!vis[poss_w] && (dist[poss_w]>distance+wt))
                {
                    dist[poss_w]=distance+wt;
                    //push adjacent vertex in queue
                    q.offer(new int[]{poss_w,dist[poss_w]});
                }
            }
        }
        return dist;
    }
}