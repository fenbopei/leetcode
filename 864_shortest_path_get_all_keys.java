class Solution {
    private static final int[][] dir = { {-1, 0}, {0, -1}, {0, 1}, {1, 0} };
    public int shortestPathAllKeys(String[] grid) {
        int R = grid.length, C = grid[0].length(), target = 0, res = 0;
        int[] A = null;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                char c = grid[i].charAt(j);
                if(c >= 'a' && c <= 'f') {
                    target |= 1 << (c - 'a');
                } else if(c == '@') {
                    A = new int[] {i, j, 0};
                }
            }
        }
        boolean[][][] visited = new boolean[R][C][target + 1];
        Deque<int[]> Q = new LinkedList<>();
        visited[A[0]][A[1]][0] = true;
        Q.add(A);
        while(!Q.isEmpty()) {
            res++;
            int s = Q.size();
            while(s-- > 0) {
                A = Q.poll();
                for(int[] d: dir) {
                    int x = A[0] + d[0], y = A[1] + d[1];
                    if(x >= 0 && x < R && y >= 0 && y < C) {
                        char c = grid[x].charAt(y);
                        if(c == '#' || (c >= 'A' && c <= 'F' && (A[2] & (1 << (c - 'A'))) == 0)) continue;
                        int keys = c >= 'a' && c <= 'f' ? A[2] | (1 << (c - 'a')) : A[2];
                        if(!visited[x][y][keys]) {
                            if(keys == target) return res;
                            visited[x][y][keys] = true;
                            Q.add(new int[] {x, y, keys});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
