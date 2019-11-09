package MS;
class numOfIslands {
    // DFS
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length; 
        int nc = grid[0].length; 
        
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return; 
            // Key Expressions, r or c out of bound, grid stop at '0' spot. 
        }
        
        grid[r][c] = '0'; 
        dfs(grid, r - 1, c); 
        dfs(grid, r + 1, c); 
        dfs(grid, r, c - 1); 
        dfs(grid, r, c + 1); 
        // recursive visit all the directions 
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0; 
        }
        
        int nr = grid.length; 
        int nc = grid[0].length; 
        int num_islands = 0; 
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') { // find a '1' means an island
                    ++num_islands; 
                    dfs(grid, r, c); 
                }
            }
        }
        return num_islands; 
    }

        // bfs
    
        public int numIslands1(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0; 
            }
            
            int nr = grid.length; 
            int nc = grid[0].length; 
            int num_islands = 0; 
            
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') { // find a '1' means an island
                        ++num_islands; 
                        grid[r][c] = '0'; // visited
                        Queue<Integer> neigh = new LinkedList<>(); 
                        neigh.add(r*nc + c); 
                        while (!neigh.isEmpty()) { // use a queue to store all the '1' grid element
                            int id = neigh.remove(); 
                            int row = id/nc; 
                            int col = id%nc; 
                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                neigh.add((row-1)*nc+col); // push 
                                grid[row-1][col] = '0'; 
                            }
                            if (row + 1 < nr && grid[row+1][col] == '1') {
                                neigh.add((row+1)*nc+col);
                                grid[row+1][col] = '0'; 
                            }
                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                neigh.add(row*nc + col-1);
                                grid[row][col-1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col+1] == '1') {
                                neigh.add(row*nc + col+1); 
                                grid[row][col+1] = '0';
                            }
                        }
                    }
                }
            }
            return num_islands; 
        }
    
    
}