class Solution {
    private int[][] dir = {{-1, 0}, {0, -1}, {0, 0}, {0, 1}, {1, 0}};
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int start = 0;
        
        //change mat to bits;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j);
            }
        }
        if (start == 0) {
            return 0;
        }
        
        boolean[] visited = new boolean[1 << (m * n)];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int minFlip = 0;
        
        while (!q.isEmpty()) {
            minFlip++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int[] e : dir) {
                            int x = j + e[0];
                            int y = k + e[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                next ^= 1 << (x * n + y);
                            }
                        }
                        
                        if (!visited[next]) {
                            if (next == 0) {
                                return minFlip;   
                            }
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
