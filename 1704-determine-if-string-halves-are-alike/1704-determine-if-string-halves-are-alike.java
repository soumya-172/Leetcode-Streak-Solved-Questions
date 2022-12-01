class Solution {
    
    // tc -> O(n/2) + O(n/2) -> O(n)
    
    public boolean halvesAreAlike(String s) {
        int size = s.length();
        int mid = size / 2;
        
        String a = s.substring(0, mid);
        String b = s.substring(mid);
        
        int cntA = 0;
        int cntB = 0;
        
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U'){
                cntA++;
            }
        }
        
        for(int i = 0; i < b.length(); i++){
            char ch = b.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U'){
                cntB++;
            }
        }
        
        return cntA == cntB;
    }
}