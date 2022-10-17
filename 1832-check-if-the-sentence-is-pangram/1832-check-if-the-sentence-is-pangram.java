class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        
        char[] strArray = sentence.toCharArray();
        
        for(char c : strArray) {
            freq[c - 'a']++;
        }
        
        for(int val : freq){
            if(val == 0){
                return false;
            }
        }
        
        return true;
        
    }
}