// gfg link ------>    https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        int dfsVis[] = new int[V];
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                if(cycleCheck(i,vis,dfsVis,adj) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean cycleCheck(int node,int vis[], int []dfsVis, ArrayList<ArrayList<Integer>> adj ) {
        
        vis[node] = 1;
        dfsVis[node] = 1;  // condition for cycle 
        for(Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                if(cycleCheck(it,vis,dfsVis,adj) == true) {
                    return true;
                }
            } else if(dfsVis[it] == 1) {
                return true;
            } 
        }
        dfsVis[node] = 0;
        return false;
    }
