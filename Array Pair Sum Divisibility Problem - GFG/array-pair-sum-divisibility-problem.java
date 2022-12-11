//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            int rem = num % k;
            int of = map.getOrDefault(rem,0);
            map.put(rem, of + 1);
            
        }
        
        for(int val : nums){
            int rem = val % k;
            
            if(rem == 0){
                int fq = map.get(rem);
                if(fq % 2 == 1){
                    return false;
                }
            }
            else if(2 * rem == k){
                int fq = map.get(rem);
                if(fq % 2 == 1){
                    return false;
                }
            }
            else{
                int fq = map.get(rem);
                int ofq = map.getOrDefault(k - rem, 0);
                if(fq != ofq) {
                    return false;
                }
            }
        }
        
        return true;
    }
}