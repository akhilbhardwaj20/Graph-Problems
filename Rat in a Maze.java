// problem link ----------->   https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// TC -> O(4^nm) as we are going to all 4 directions                                                 source    __    
// SC -> O(n*m) as we are using auxiliary space and moving to depth of the recursion tree like --->   | |  | |  |
                                                                                                      | |  | |  |
                                                                                                      | |  | |  |
                                                                                                      |_|  |_|  |__dest

class Solve {
    public static ArrayList<String> printPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        String s = "";
        dfs(m, n, res, 0, 0, s);
        return res;
    }
    
    private static void dfs(int [][]m, int n, ArrayList<String> res, int i, int j, String s) {
        if(i < 0 || i >= n || j < 0 || j >= n || m[i][j] == 0) {
            // s.remove;
            //we have taken the wrong step, we go back
            return;
        }
        if(i == n - 1 && j == n - 1) {
            res.add(s + "");
            return;
        } 
        m[i][j] = 0;   // we have visited this cell 
        dfs(m, n, res, i + 1, j, s + "D");
        dfs(m, n, res, i, j - 1, s + "L"); 
        dfs(m, n, res, i, j + 1, s + "R");
        dfs(m, n, res, i - 1, j, s + "U");
        m[i][j] = 1;  // mark as unvisited
    }
}
