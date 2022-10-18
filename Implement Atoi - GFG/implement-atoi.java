//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
    	int ans = 0;
    	
    	int ind = 0;
    	int flag = 0; // it shows that the is neg or not
    	
    	if(str.charAt(ind) == '-'){
    	    ind = 1;
    	    flag = 1;
    	}
    	
    	for(; ind < str.length(); ind++){
    	    if(str.charAt(ind) >= 48 && str.charAt(ind) <= 57){
    	        ans = ans * 10 + (str.charAt(ind) - 48);
    	    }else{
    	        return -1;
    	    }
    	}
    	
    	if(flag != 0) {
    	    return -1 * ans;
    	}
    	
    	return ans;
    }
}
