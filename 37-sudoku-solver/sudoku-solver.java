class Solution {
    public void solveSudoku(char[][] board) {
        solution(board, 0,0);
    }
    private boolean solution(char[][]board, int row, int col){
        if(row==9)
        return true;
        
        int nextRow=row;
        int nextCol=col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(board[row][col]!='.'){
            return solution(board, nextRow, nextCol);
        }
        for(char dig='1'; dig<='9'; dig++){
            if(isValid(board, row, col, dig)){
                board[row][col]=dig;
                if(solution(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    private boolean isValid(char[][]board, int row, int col, char dig){
        for(int i=0; i<9; i++){
            if(board[i][col]==dig)
            return false;
        }
        for(int j=0; j<9; j++){
            if(board[row][j]==dig){
                return false;
            }
        }

        int startingRow=(row/3)*3;
        int startingCol=(col/3)*3;
        for(int i=startingRow; i<=startingRow+2; i++){
            for(int j=startingCol; j<=startingCol+2; j++){
                if(board[i][j]==dig){
                    return false;
                }
            }
        }

        return true;

    }
}