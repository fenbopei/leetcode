class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{0, 0},{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        LinkedList<int[]> q = new LinkedList<>();
        q.addLast(new int[]{0, 0, 0});
        //visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                //System.out.println("tar" + cur[0] + cur[1]);
                return cur[2];
            }
            
            visited[cur[0]][cur[1]] = true; 
            for (int i = 1;  i <= 4; i++) {
                int newX = cur[0] + dir[i][0];
                int newY = cur[1] + dir[i][1];
                
                if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) {
                    continue;
                }
                
                if (grid[cur[0]][cur[1]] == i) {
                    q.addFirst(new int[]{newX, newY, cur[2]});
                    //System.out.println(newX + " " + newY);
                    //visited[newX][newY] = true;
                }
                else{
                    q.addLast(new int[]{newX, newY, cur[2] + 1});
                    //visited[newX][newY] = true;
                    //System.out.println(newX + " " + newY + "cost");    
                }
            }
        }
        
        return -1;
    }
}
