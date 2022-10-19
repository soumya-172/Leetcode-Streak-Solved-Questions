class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        // counting the frequency of each word
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else{
                map.put(words[i],1);
            }
        }
        
        // custom comparater for comparing the words
        Queue<String> q = new PriorityQueue<>((w1,w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        
        // add to the heap
        for(String word : map.keySet()){
            q.add(word);
            
            if(q.size() > k) q.poll(); 
        }
        
        // add to the result
        List<String> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll());
        }
        
        Collections.reverse(result);
       
        return result;
    }
}