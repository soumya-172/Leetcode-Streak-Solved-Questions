//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Node {
    int first;
    int second;
    int third;
    
    Node(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution
{
    // tc -> O(n*m) approx
    // sc -> O(n*m)
    // bfs
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];
        Queue<Node> q = new LinkedList();
        
        // n * m
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new Node(i,j,0));
                    visited[i][j] = 1;
                } else{
                    visited[i][j] = 0;
                }
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        // n * m * 4
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.poll();
            distance[row][col] = steps;
            
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    q.offer(new Node(nRow,nCol,steps+1));
                }
            }
        }
        
        return distance;
    }
}






























