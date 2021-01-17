class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //using bfs
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int m = maze.length;
        int n = maze[0].length;
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                while (inBoard(newX, newY, m, n) && maze[newX][newY] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                }
                
                //if the ball run to the wall, it should be step back one step;
                newX -= dx[i];
                newY -= dy[i];
                if (inBoard(newX, newY, m, n) && !visited[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        } 
        
        return false;
    }
    
    private boolean inBoard(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
