class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int remainder = 0;
        
        for(int i = 0; i < nums.length; i++){
            remainder += nums[i];
            if(k != 0) remainder %= k;
            
            if(map.containsKey(remainder)){
                if(i - map.get(remainder) > 1) return true;
            }else{
                map.put(remainder, i);
            }
        }
        return false;
    }
    
   
}