class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[i].length - 1; j >= 0; j--){
                if(i == 0 || j == 0) continue;
                if(matrix[i][j] != matrix[i - 1][j - 1]){
                    return false;
                }
            }
        }
        return true;
    }
}