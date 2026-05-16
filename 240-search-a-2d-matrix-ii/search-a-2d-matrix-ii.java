class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean ans=false;

        int row=0;
        int col=n-1;

        while(row<m && col>=0){
            if(target==matrix[row][col]){
                return true;
            }
            else if(target>matrix[row][col]){
                row++;
            }
            else{
                col--;
            }
        }
        return ans;
    }
}