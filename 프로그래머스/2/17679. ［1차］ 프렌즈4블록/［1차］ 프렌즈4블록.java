class Solution {
    
    final char BLANK = 'x';
    final int[] dr = {0, 1, 1};
    final int[] dc = {1, 1, 0};
    
    int m, n;
    char[][] board;
    boolean[][] erased;
    boolean finish = false;
    
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = new char[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                this.board[r][c] = board[r].charAt(c);
            }
        }

        while (!finish) {
            finish = true;
            erase();
            fallOff();
        }
        
        int answer = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (this.board[r][c] == BLANK) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void erase() {
        erased = new boolean[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == BLANK) {
                    continue;
                }
                
                boolean check = true;
                
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (!rangeIn(nr, nc) || board[r][c] != board[nr][nc] || board[nr][nc] == BLANK) {
                        check = false;
                        break;
                    }
                }
                
                // 2x2 블록을 지울 수 있는 경우
                if (check) {
                    finish = false;
                    erased[r][c] = true;
                    for (int i = 0; i < 3; i++) {
                        erased[r + dr[i]][c + dc[i]] = true;
                    }
                }
            }
        }
        
        // board에서 지워진 블록을 표시한다.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (erased[r][c]) {
                    board[r][c] = BLANK;
                }
            }
        }
    }
    
    private void fallOff() {
        for (int c = 0; c < n; c++) {
            char[] tmp = new char[m];
            int idx = m - 1;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] != BLANK) {
                    tmp[idx--] = board[r][c];
                }
            }
            
            while (idx >= 0) {
                tmp[idx--] = BLANK;
            }
            
            for (int i = 0; i < m; i++) {
                board[i][c] = tmp[i];
            }
        }
    }
    
    private boolean rangeIn(int r, int c) {
        return (r >= 0) && (c >= 0) && (r < m) && (c < n);
    }
}