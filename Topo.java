// LINK ---------->   https://practice.geeksforgeeks.org/problems/topological-sort/1

class Solution
{
  TC- O(N+E)  SC - O(N) for visited array and O(n) for stack space/ Auxiliary space
    //Function to return list containing vertices in Topological order. 
    
    private static void findTopoSort(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer>st) {
        
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                vis[it] = true;
            }
        }
        st.push(node);
        
        
    } 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // DFS
        Stack<Integer>st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                findTopoSort(i,vis,adj,st);
            }
        }
        int []topo = new int[V];
        int index = 0;
        while(!st.isEmpty()) {
            topo[index++] = st.pop();
        }
        
        return topo;
        
    }
}
