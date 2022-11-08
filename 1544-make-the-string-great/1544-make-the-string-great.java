class Solution {
    public String makeGood(String s) {
        
        // using stack
        // tc -> o(n), sc -> o(n) i.e. for using stack
        
        Stack<Character> stack = new Stack();
        
        char[] chArr = s.toCharArray();
        
        for(char ch : chArr){
            if(!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32){
                stack.pop();
            }else{
                stack.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(stack.size() > 0){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}