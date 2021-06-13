class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // corner case : if our newColor to be filled is the same as the grid[i][j] we simply return that
        if(newColor == image[sr][sc]) return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        // image[sr][sc] = oldcolor
        return image;
        
    }
    
    private void dfs(int[][] image, int i, int j, int color, int oldColor) {
        int m = image.length;
        int n = image[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor) return;
        
        // first make the grid[i][j] with new color
        image[i][j] = color;
        dfs(image,i,j-1,color,oldColor);    // left call
        dfs(image,i-1,j,color,oldColor);    // top call
        dfs(image,i,j+1,color,oldColor);    // right call
        dfs(image,i+1,j,color,oldColor);    // down call
        
        // TC - O(m*n) , SC - O(m*n)
    } 
}
