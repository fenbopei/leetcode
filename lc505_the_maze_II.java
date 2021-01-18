class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        PriorityQueue<Posn> q = new PriorityQueue<Posn>((p1, p2)->(p1.len - p2.len));
        q.offer(new Posn(start[0], start[1], 0));
        boolean[][] visit = new boolean[m][n];

        while(!q.isEmpty()){
            Posn cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if(x == destination[0] && y == destination[1]){
                return cur.len;
            }
            if(visit[x][y]){
                continue;
            }
            visit[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;
                int len = cur.len;
                while(nx >= 0 && nx < m  && ny >= 0 && ny < n && maze[nx][ny] == 0){
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                }
                len--;
                nx -= dx[i];
                ny -= dy[i];
                q.offer(new Posn(nx, ny, len));
                         
            }
        }
        return -1; 
    }
}

class Posn{
    int x;
    int y;
    int len;
    public Posn(int a, int b, int len){
        x = a;
        y = b;
        this.len = len;
    }
}
