class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // to store the last occuring index of each element
        Map<Integer,Integer> map = new HashMap<>();
        
        // loop through thr array
        for(int i = 0; i < nums.length; i++){
            
            // check if the element already exist in the map if it does then check for if the diff. between the last occuring index and the latest index is <= k or not
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                }else{
                    // if <=k then update the index with current index
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}