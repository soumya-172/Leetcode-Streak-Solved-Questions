class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> st = new Stack();
        
        char[] chArr = s.toCharArray();
        
        for(char ch : chArr){
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
                continue;
            }else{
                st.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}