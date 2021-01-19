class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        
        int water = 0;
        toQueue(pq, heightMap, visited, m, n);
        int max = Integer.MIN_VALUE;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            max = Math.max(max, heightMap[cur[0]][cur[1]]);
            
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                pq.offer(new int[]{x, y});
                visited[x][y] = true;
            }
            
            if (heightMap[cur[0]][cur[1]] < max) {
                water += max - heightMap[cur[0]][cur[1]];
            }
        }
        
        return water;  
    }
    
    public void toQueue(PriorityQueue<int[]> pq, int[][] heightMap, boolean[][] visited, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m -1 || j == n - 1) {
                    pq.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }
}
