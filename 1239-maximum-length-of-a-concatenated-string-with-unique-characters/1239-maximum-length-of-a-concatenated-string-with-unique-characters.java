class Solution {
    public int maxLength(List<String> arr) {
        
        int[] selected = new int[26];
        
        return help(0, arr, selected, 0);
        
    }
    
    public int help(int i, List<String> arr, int[] selected, int len){
        
        if(i == arr.size()) {
            return len;
        }
        
        String currString = arr.get(i);
        
        if(compare(selected,currString) == false){
            return help(i+1, arr, selected, len);
        }else{
            //pick element
            for(int j = 0; j < currString.length(); j++){
                selected[currString.charAt(j) - 'a'] = 1;
            }
            
            len += currString.length();
            int op1 = help(i+1, arr, selected, len);
            
            
            //skip element
            for(int j = 0; j < currString.length(); j++){
                selected[currString.charAt(j) - 'a'] = 0;
            }
            
            len -= currString.length();
            int op2 = help(i+1, arr, selected, len);
            
            return Math.max(op1,op2);
        }
    }
    
    public boolean compare(int[] selected, String currString){
        int[] selfCheck = new int[26];
         
        for(int i = 0; i < currString.length(); i++){
            char ch = currString.charAt(i);
            
            if(selfCheck[ch - 'a'] == 1) return false;
            selfCheck[ch - 'a'] = 1;
        }
        
        for(int i = 0; i < currString.length(); i++){
            char ch = currString.charAt(i);
            
            if(selected[ch - 'a'] == 1) return false;
        }
        return true;
    }
}