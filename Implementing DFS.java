Problem Link --------->    https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>storeDfs) {
        
        storeDfs.add(node);
        vis[node] = true;
        for(Integer it : adj.get(node)) {
            if(vis[it] == false) {
                dfs(it,vis,adj,storeDfs);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean []vis = new boolean[V+1];
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }
}

// TC - O(N+E) ---> O(N) for traversing n nodes 
// SC - O(N+E) + O(N) + O(N) ---> space for adj list, visited array and auxiliary space respectively.
