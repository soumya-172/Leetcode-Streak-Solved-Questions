class Solution {
    
    public static class Node {
        //definition of Trie
        Node[] childs = new Node[26]; 
        String str;
        
        // insert function of trie
        public void insert(String s){
            Node curr = this;
            
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(curr.childs[ch - 'a'] == null){
                    curr.childs[ch - 'a'] = new Node();
                }
                
                curr = curr.childs[ch - 'a'];
            }
            
            curr.str = s;
        }
        
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Node root = new Node();
        for(String s : words){
            root.insert(s);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, ans, visited);
            }
        }
        return ans;
    }
    
    public static void dfs(char[][] board, int i, int j, Node root, ArrayList<String> ans, boolean[][] visited){
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true) return;
        
        if(root.childs[board[i][j] - 'a'] == null) return;
        
        Node child = root.childs[board[i][j] - 'a'];
        if(child.str != null){
            ans.add(child.str);
            child.str = null;
        }
        visited[i][j] = true;
        dfs(board, i+1, j, child, ans, visited);
        dfs(board, i-1, j, child, ans, visited);
        dfs(board, i, j+1, child, ans, visited);
        dfs(board, i, j-1, child, ans, visited);
        visited[i][j] = false;
                              
    }
}