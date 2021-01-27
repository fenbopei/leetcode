class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Map<Integer, Integer> dist = new HashMap();
        dist.put(1, 0);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == N * N) {
                return dist.get(cur);
            }
            
            for (int next = cur + 1; next <= Math.min(cur + 6, N * N); next++) {
                int rc = get(next, N);
                int r = rc / N, c = rc % N;
                int nextFinal = board[r][c] == -1 ? next : board[r][c];
                if (!dist.containsKey(nextFinal)) {
                    dist.put(nextFinal, dist.get(cur) + 1);
                    q.offer(nextFinal);
                }
            }
        }
        
        return -1;
    }
    
    private int get(int s, int N) {
        int quot = (s-1) / N;
        int rem = (s-1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
}
