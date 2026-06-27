class Solution {
    public List<List<String>> solveNQueens(int n) {
        String[][] board=new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=".";
            }
        }
        List<List<String>> result= new ArrayList<>();
        nQueens(board, 0, n, result);
        return result;
    }

    private void nQueens(String[][]board, int row, int n, List<List<String>> result){
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(String[]nums : board){
                StringBuilder sb = new StringBuilder();
                for(String num : nums){
                    sb.append(num);
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        for(int j=0; j<n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j]="Q";
                nQueens(board, row+1, n, result);
                board[row][j]=".";
            }
        }
    }

    private boolean isSafe(String[][] board, int row, int col, int n){
        for(int i=0; i<n; i++){
            if(board[i][col]=="Q")
            return false;
        }
        for(int j=0; j<n; j++){
            if(board[row][j]=="Q")
            return false;
        }
        
        for(int i=row,j=col; i>=0 && j>=0; i--,j-- ){
            if(board[i][j]=="Q")
            return false;
        }
        for(int i=row,j=col; i>=0 && j<n; i--,j++ ){
            if(board[i][j]=="Q")
            return false;
        }

        return true;
    }
}