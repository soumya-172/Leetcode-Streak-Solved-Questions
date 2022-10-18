class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        // calling recursion
        String str = countAndSay(n - 1);
        
        int count = 0;
        String res = "";
        for(int i = 0; i < str.length(); i++){
            count++;
            //seggregating into groups
            if((i == str.length() - 1) || (str.charAt(i) != str.charAt(i + 1))){
                res = res + count + str.charAt(i);
                count = 0;
            }
        }
        return res;
    }
    
}