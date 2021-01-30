class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //using 2 bfs;
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        //Set<int[]> visitedP = new HashSet<>();
        //Set<int[]> visitedA = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacific.add(new int[]{i, j});
                    visitedP[i][j] = true;
                }
                if (i == m - 1 || j == n - 1) {
                    atlantic.add(new int[]{i, j});
                    visitedA[i][j] = true;
                }
            }
        }
        
        bfs(pacific, visitedP, matrix, m, n);
        bfs(atlantic, visitedA, matrix, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        
        return res;
    }
    
    // to find all cell can flow which ocean;
    private void bfs(Queue<int[]> q, boolean[][] visited, int[][] matrix, int m, int n){
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dir[i][0];
                int newY = cur[1] + dir[i][1];
                if (isValid(newX, newY, m, n) && !visited[newX][newY] && matrix[newX][newY] >= matrix[cur[0]][cur[1]]) {
                    q.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        } 
    }
    
    private boolean isValid(int x, int y, int m, int n){
        return x >=0 && x < m && y >= 0 && y < n;
    }
}
