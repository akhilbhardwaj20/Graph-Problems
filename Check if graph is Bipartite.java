class Solution {
    //TC - O(V+E) , SC -O(N) + O(N) 
    public boolean isBipartite(int[][] graph) {
        
        int []color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) {
                if(!bfscheck(i,graph,color)) {
                    return false;
                }
            }
        
        }
        return true;
    }
    
    private boolean bfscheck(int node, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        
        while(!q.isEmpty()) {
            Integer n = q.poll();
        for(int it : graph[n]) {
            if(color[it] == color[n]) {
                return false;
            } else if(color[it] == -1) {
                q.add(it);
                color[it] = 1 - color[n];
            }
        }
      }
           return true; 
    }
}
