// TC - O(N) , SC - O(N) where N is the no of nodes
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));       // make a <K,V> pair where K = original node and //V = cloned node + neighbours as arraylist
        while(!q.isEmpty()) {
            Node n = q.poll();
            for(Node child : n.neighbors) {
                if(!map.containsKey(child)) {
                    //mark the clone neighbor as visited
                     map.put(child, new Node(child.val, new ArrayList<>()));
                     q.add(child);
                }
                // add the clone neighbors to the clone node
                map.get(n).neighbors.add(map.get(child));   // queue mein se utha ke map mein daal diya 
               
            }
            
        }
           
            return map.get(node);
            
        
    }
}
