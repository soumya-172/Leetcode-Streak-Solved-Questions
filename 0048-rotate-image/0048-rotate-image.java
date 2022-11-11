class Solution {
    public void rotate(int[][] matrix) {
        
        int i = 0, j = matrix.length - 1;
        
        // System.out.println(j);
        
        // in this move the 1st row -> last row and last row -> 1st row, basically interchane the rows 
        while(i < j){
            for(int l = 0; l < matrix[0].length; l++){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[j][l];
                matrix[j][l] = temp;
            }
            i++;
            j--;
        }
        
        // after interchaging the rows transpose the matrix 
        for(int k = 0; k < matrix.length; k++){
            for(int l = k; l < matrix[0].length; l++){
                int temp = matrix[k][l];
                matrix[k][l] = matrix[l][k];
                matrix[l][k] = temp;
            }
        }
        
    }
}