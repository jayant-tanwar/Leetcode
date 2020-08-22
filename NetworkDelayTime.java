Question: There are N network nodes, labelled 1 to N.
Given ties, a list of travel times as directed egdes times[i] = (u,v,w),
where u is the source node, v is the target node, and w is the time it takes for a signal
to travel from source to target.

Now we send a singal from a certain node K. How long will it take for all the nodes to receive the signal?
If it is impossible, return -1.


times = [[2,1,1],[2,3,1],[3,4,1]]
N = 4
K = 2
Output = 2


class Solution {

    public int networkDelayTime(int[][] times, int N, int K){
      HashMap<Integer,ArrayList<Integer>>  G = new HashMap<>();
      int[][] W = new int[N+1][N+1];
      
      for(int[] e: times){
        int u = e[0];
        int v = e[1];
        int w = e[2];
        W[u][v]=w;
        if(G.containsKey(u)==false){
            G.put(u , new ArrayList<Integer>()):
        }
        ArrayList<Integer> L = G.get(u);
        L.add(v);
        G.put(u,L);
      }
      
      int[] prev = new int[N+1];
      int[] dist = new int[N+1];
      boolean[] V = new boolean[N+1];
      
      Arrays.fill(dist,Integer.MAX_VALUE);
      PriorityQueue<Integer> PQ = new PriorityQueue<Integer>((a,b) ->(dist[a]-dist[b]));
      dist[K]=0;
      int max = Integer.MIN_VALUE;
      for(int i=1;i<=N;i++){
          PQ.add(i);
          //Remeber we are adding indes as nodes! and not distances,
          //distances are taken care of automatically by the comparator.
      }
      
      
      
      while(!PQ.isEmpty()){
          int u = PQ.poll();
          V[u] = true;
          for(int v: G.getOrDefault(u, new ArrayList<Integer>()){
              if(!V[v]){
                  int alt = dist[u]+W[u][v];
                  if(alt<dist[v]){
                    //update
                    PQ.remove(v)
                    dist[v]=alt;
                    prev[u]=u;
                    PQ.add(v);
                    //adding removing in order to re-calibrate the priority queue
                  }
              }
          }
          
          
          for(int i=1;i<=N;i++){
              max = Math.max(max,dist[i]);
          }
          if(max==Integer.MAX_VALUE) return -1;
          return max;
      }
      
      
      
      
      
      
