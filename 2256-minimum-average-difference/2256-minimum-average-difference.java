class Solution {
    
     // tc -> O(N)
     // sc -> O(1)
    
    // prefix sum
    
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length, index = - 1;
        
        long sum = 0, lsum = 0, rsum = 0, mini = Integer.MAX_VALUE;
        
        for(int num : nums){
            sum += num;
        }
        
        for(int i = 0; i < n ; i++){
            lsum += nums[i];
            rsum = sum - lsum;
            
            long diff = Math.abs(lsum / (i + 1) - (n - i == 1 ? 0 : (rsum / (n - i - 1))));
            
            if(diff < mini){
                mini = diff;
                index = i;
            }
        }
        
        return index;
    }
    
    
}