class RandomizedSet {
    
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) {
            return false;
        }
        
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)){
            return false;
        } 
        
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int size = set.size();
        
        int rand_ind = rand.nextInt(size);
        
        List<Integer> list = new ArrayList<Integer>(set); // it converts the set into list
        
        return list.get(rand_ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */