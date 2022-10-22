class Solution {
    public String minWindow(String s, String t) {
        
        String ans = "";
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        // count freq of characters of string t
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        int mct = 0;//match count
        int dmct = t.length();//desired match count
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map1 = new HashMap<>();
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            //aquire           
            while(i < s.length() - 1 && mct < dmct){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0) + 1);
                
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    mct++;
                }
                flag1 = true;
            }
            
            //collect answers and release
            while(j < i && mct == dmct){
                String pans = s.substring(j + 1, i + 1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch) - 1);
                }
                
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    mct--;
                }
                
                flag2 = true;
            }
            
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        
        
        return ans;
    }
}