Problem Link ----------->    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> c = new ArrayList<>();
        boolean []vis = new boolean[V+1];
        Queue<Integer>q = new LinkedList<>();
                vis[0] = true;
                q.add(0);
                while(!q.isEmpty()) {
                    Integer node = q.poll();
                    c.add(node);
                    for(Integer it : adj.get(node)) {
                        if(vis[it] == false) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            
        
        return c;
    }
}
