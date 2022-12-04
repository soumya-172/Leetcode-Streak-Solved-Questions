//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        
        int[] vowel = new int[26];
        int[] cons = new int[26];
        int vc = 0, cc = 0;
        
        for(char ch : S.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowel[ch - 'a']++;
                vc++;
            }else{
                cons[ch - 'a']++;
                cc++;
            }
        }
        
        if(Math.abs(vc - cc) > 1) return "-1";
        
        if(vc >= cc){
            return helper(vowel,cons);
        }else{
            return helper(cons, vowel);
        }
    }
    
    public static String helper(int[] arr1, int[] arr2){
        int i = 0, j = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(i < arr1.length && j < arr2.length){
            
            while(i < arr1.length && arr1[i] == 0) i++;
            if(i < arr1.length){
                if(arr1[i] != 0){
                    sb.append((char)(i + 'a')); // i + 'a' defines that if the char is b to be append 
                    // then i + 'a' gives the value b (if i = 1, then i + 'a' = 1 + 97 = 98 = b)
                    // System.out.println("V" + (char)(i + 'a'));
                    arr1[i]--;
                }
            }
            
            while(j < arr2.length && arr2[j] == 0) j++;
            if(j < arr2.length && arr2[j] != 0){
                sb.append((char)(j + 'a'));
                // System.out.println("C" + (char)(j + 'a'));
                arr2[j]--;
            }
        }
        
        return sb.toString();
    }
}