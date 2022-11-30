class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>(map.values());
        
        // System.out.println(map.size());
        // System.out.println(set.size());
        
        
        return map.size() == set.size();
    }
}