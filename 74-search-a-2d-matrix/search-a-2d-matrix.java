class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=matrix.length-1;
        int col=matrix[0].length-1;

        int low=0;
        int high=row;

        while(low<=high){
            int mid=low+(high-low)/2;
            int lowCol=0;
            int highCol=col;
            if(target>=matrix[mid][0] && target<=matrix[mid][highCol]){
                while(lowCol<=highCol){
                    int midCol=lowCol+(highCol-lowCol)/2;
                    if(target==matrix[mid][midCol]){
                        return true;
                    }
                    else if(target>matrix[mid][midCol]){
                        lowCol=midCol+1;
                    }
                    else{
                        highCol=midCol-1;
                    }
                }
                return false;
            }
            else if(target>matrix[mid][0]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}