class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> bankSt = new HashSet<>(), seen = new HashSet<String>();
        for(String str : bank){
            bankSt.add(str);
        }
        
        char[] choices = {'A','C','G','T'};
        
        Queue<String> q = new LinkedList<>();
        int mutations = 0;
        
        q.offer(start);
        seen.add(start);
        
        
        char[] currArr;
                
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                String curr = q.poll();
                
                if(curr.equals(end)) return mutations;
                
                currArr = curr.toCharArray();
                
                for(int i = 0; i < currArr.length; i++){
                    char oldCh = currArr[i];
                    
                    for(char ch : choices){
                        currArr[i] = ch;
                        
                        String newStr = new String(currArr);
                        
                        if(!seen.contains(newStr) && bankSt.contains(newStr)){
                            q.offer(newStr);
                            seen.add(newStr);
                        }
                    }
                    currArr[i] = oldCh;
                }
            }
            mutations++;
        }
        
        return -1;
    }
}









