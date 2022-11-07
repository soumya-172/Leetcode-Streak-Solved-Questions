class Solution {
    public int maximum69Number (int num) {
        
        // replaceFirst("replacing ele","replace with ele") -> replaces the first occurance of 6 with 9 in the string
        
        return Integer.parseInt(String.valueOf(num).replaceFirst("6","9"));
    }
}