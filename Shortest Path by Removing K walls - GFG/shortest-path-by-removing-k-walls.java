//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<int[]> q = new LinkedList<>();
        int steps = 0;
        
        q.offer(new int[] {0,0,k});
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] curr = q.poll();
                
                // we are in the last cell
                if(curr[0] == n - 1 && curr[1] == m - 1) return steps;
                
                // otherwise move all directions
                for(int[] d : DIR){
                    int i = curr[0] + d[0];
                    int j = curr[1] + d[1];
                    int obs = curr[2];
                    
                    //Traverse through the valid cells
                    if(i >= 0 && i < n && j >= 0 && j < m){
                        //If cell is empty visit the cell and add in queue
                        if(mat[i][j] == 0 && !visited[i][j][obs]){
                            q.offer(new int[]{i,j,obs});
                            visited[i][j][obs] = true;
                        }
                        else if(mat[i][j] == 1 && obs > 0 && !visited[i][j][obs - 1]){
                            q.offer(new int[]{i,j,obs-1});
                            visited[i][j][obs - 1] = true;
                        }
                    }
                }
            }
            ++steps;
        }
        
        return -1;
    }
};