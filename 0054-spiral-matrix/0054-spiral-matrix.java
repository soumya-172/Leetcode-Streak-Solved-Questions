class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        
        int m =matrix.length;
        int n = matrix[0].length;
        
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length - 1;
        int maxc = matrix[0].length - 1;
        
        int tne = m * n;
        int cnt = 0;
        
        // considering it box by box traversal
        while(cnt < tne){
            // top wall
            for(int i = minr, j = minc; j <= maxc && cnt < tne; j++){
                ans.add(matrix[i][j]);
                cnt++;
            }
            minr++;
            
            // right wall
            for(int i = minr, j = maxc; i <= maxr && cnt < tne; i++){
                ans.add(matrix[i][j]);
                cnt++;
            }
            maxc--;
            
            // bottom wall
            for(int i = maxr, j = maxc; j >= minc && cnt < tne; j--){
                ans.add(matrix[i][j]);
                cnt++;
            }
            maxr--;
            
            // left wall
            for(int i = maxr, j = minc; i >= minr && cnt < tne; i--){
                ans.add(matrix[i][j]);
                cnt++;
            }
            
            minc++;
        }
        
        return ans;
    }
}