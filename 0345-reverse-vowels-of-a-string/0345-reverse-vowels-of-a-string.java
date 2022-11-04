class Solution {
    public String reverseVowels(String s) {
        
        
        char[] revVowel = s.toCharArray();
        
        int left = 0, right = revVowel.length - 1;
        
        while(left < right){
            //left vowel
            while(left < right && isVowel(revVowel,left) == false){
                left++;
            }
            
            //right vowel
            while(left < right && isVowel(revVowel,right) == false){
                right--;
            }
            
            //swap the vowels
            char ch = revVowel[left];
            revVowel[left] = revVowel[right];
            revVowel[right] = ch;
            
            left++;
            right--;
        }
        
        String str = "";
        
        for(char ch : revVowel){
            str += ch;
        }
        
        return str;
    }
    
   public boolean isVowel(char[] revVowel, int ind){
        
        char[] vowel = {'a','A','e','E','i','I','o','O','u','U'};
        
        for(char ch : vowel){
            if(ch == revVowel[ind]){
                return true;
            }
        }
        return false;
    }
}