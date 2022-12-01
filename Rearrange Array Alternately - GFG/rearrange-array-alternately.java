//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // here the idea used is Dividend = Quotient * Divisor + Remainder
        // and we have to store 2 values in one index. here new value acts as quotient and lod value acts as Remainder.
        
       int max_ind = n - 1;
       int min_ind = 0;
       
       long maxi = arr[max_ind] + 1;
       
       for(int i = 0; i < n; i++){
           if(i % 2 == 0){
               arr[i] = (arr[max_ind] % maxi) * maxi + arr[i];
               max_ind--;
           }
           
           if(i % 2 != 0){
               arr[i] = (arr[min_ind] % maxi) * maxi + arr[i];
               min_ind++;
           }
       }
       
       for(int i = 0; i < n; i++){
           arr[i] = arr[i] / maxi;
       }
        
    }
    
}


