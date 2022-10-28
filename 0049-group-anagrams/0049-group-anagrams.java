class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character,Integer> , ArrayList<String>> bmap = new HashMap<>();
        
        for(String str : strs){
            Map<Character,Integer> fmap = new HashMap<>(); // frequency map for counting character
            
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1); 
            }
            
            if(bmap.containsKey(fmap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(fmap,list);
            }else{
                ArrayList<String> list = bmap.get(fmap); //key fmap already presents then .get will return the value i.e the List of anagram string 
                list.add(str);
            }
            
        }
        
        ArrayList<List<String>> result = new ArrayList<>();
            for(ArrayList<String> val : bmap.values()){ //bmap.values() returns all the value set of the map
                result.add(val);
            }
        return result;
    }
       
}