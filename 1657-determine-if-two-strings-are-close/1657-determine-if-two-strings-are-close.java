class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length() != word2.length()) return false;
        
        int[] v1 = new int[26];
        int[] v2 = new int[26];
        int[] v11 = new int[26];
        int[] v22 = new int[26];
        
        for(char ch : word1.toCharArray()){
            v1[ch - 'a']++;
            v11[ch - 'a'] = 1;
        }
        
        for(char ch : word2.toCharArray()){
            v2[ch - 'a']++;
            v22[ch - 'a'] = 1;
        }
        
        Arrays.sort(v1);
        Arrays.sort(v2);
        
        return (Arrays.equals(v1,v2) && Arrays.equals(v11,v22));
    }
}