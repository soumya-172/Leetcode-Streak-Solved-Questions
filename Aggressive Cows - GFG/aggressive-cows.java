//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // tc for BS -> O(logN)
    // hence overall tc -> O(logN * N)
    
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[n - 1] - stalls[0];
        int res = 0;
        
        while(low <= high){
            int mid = (low + high) >> 1;
            
            if(canPlaceCow(stalls, n, k, mid)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return res;
    }
    
    // tc for this -> O(N)
    public static boolean canPlaceCow(int[] stalls, int n, int k, int dis){
        
        int co_ord = stalls[0];
        int cnt = 1;
        
        for(int i = 1; i < n; i++){
            if(stalls[i] - co_ord >= dis){
                co_ord = stalls[i];
                cnt++;
            }
            
            if(cnt == k) return true;
        }
        return false;
    }
}