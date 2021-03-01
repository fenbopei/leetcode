class Solution {
    private List<List<String>> res;
        
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; 
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        res = new LinkedList<>();
        dfs(board, visited, 0, n);
        
        return res;
    }
    
    private void dfs(char[][] board, int[][] visited, int row, int queens){
        if (queens == 0) {
            addToResult(board);
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (visited[row][col] == 0) {
                board[row][col] = 'Q';
                visit(visited, row, col, 1);
                
                dfs(board, visited, row + 1, queens - 1);
                
                board[row][col] = '.';
                visit(visited, row, col, -1);
            }
        }   
    }
    
    private void addToResult(char[][] board) {
        List<String> validState = new LinkedList<>();
        
        for (char[] row : board) {
            validState.add(new String(row));
        }
        
        res.add(validState);
    }
    
    private void visit(int[][] visited, int row, int col, int value) {
        int n = visited.length;
        //diagnal
        for (int i = 0; i + row < n && i + col < n; i++) {
            visited[i + row][i + col] += value;
        }
        
        for(int i = 0; row - i >= 0 && col - i >= 0; i++) {
            visited[row - i][col - i] += value;
        }
        
        //anti diagnal;
        for(int i = 0, j = 0; i + row < n && col - j >= 0; i++, j++) {
            visited[i + row][col - j] += value;
        }
        
        for(int i = 0, j = 0; row - i >= 0 && col + j < n; i++, j++) {
            visited[row - i][col + j] += value;
        }
        
        //row
        for(int i = 0; i < n; i++) {
            visited[row][i] += value;
        }
        
        //col
        for(int i = 0; i < n; i++) {
            visited[i][col] += value;
        } 
    }
}
