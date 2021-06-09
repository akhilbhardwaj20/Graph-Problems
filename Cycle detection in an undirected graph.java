
// GFG link ---->https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 public boolean cycleCheck(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;  // whenever we reach a node we mark it as visited
        for(Integer it : adj.get(node)) {
            if(vis[node] == false) {
                if(cycleCheck(it,node,vis,adj) == true) return true;
            } else if(it != parent) {
                return true;
            }
        }
        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean []vis = new boolean[V+1];
        for(int i = 0; i < vis.length; i++) {
            vis[i] = false;
        }
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {   // if not visited previously
                if(cycleCheck(i,-1,vis,adj)) {  // if the recursion finds a cycle
                    return true;
                }
            }
        }
        return false;
    }
