// Connecting Cities With Minimum Cost (Biweekly Contest 5) LC -1135
class Solution {
    
    int []rank;
    int findParent(int p) {
        if(rank[p] != p) {          // As long as the parent of the node is diferent
            rank[p] = findParent(rank[p]);      // we assign the parent to its parent node                                                    // (worst case - O(N)) for same par - O(1)
        }
        return rank[p];
    }
    
    void union(int u, int v) {
        rank[findParent(u)] = findParent(v);      // merge parent of City A and B together
    }
    public int minimum Cost(int N, int[][] connections) {
        rank = new int[N];
        // make every node's parent pointing to itself
        for(int i = 0; i < N; i++) {
            rank[i] = i;
        }
        // use sort to start from the lowestcost of the path
        Arrays.sort(connections, (c1,c2)-> (
             return c1[2]-c2[2];
        ));
        
        int cost = 0;
        // look through all the connections with a cost
        for(int con : connections) {
            // if the nodes are a part of different group, add the cost of merging them 
            if(findParent(con[0]-1) != findParent(con[1]-1)) {
                cost += con[2];
                // now join the grp , like grp A and B into one
                union(con[0]-1, con[1]-1);
            }
        }
        int group = findParent(0);
        for(int i = 0; i < N; i++) {
            if(findParent(i) != group)  // if all cities(groups) are not connected
                   return -1;                     // for eg -->       1---->2
                                                         // 3---->4
        }
        return cost;
    }
}
