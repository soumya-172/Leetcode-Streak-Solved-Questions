class StockSpanner {
    
    // next gretar element to left same pattern -> in this instead of storing the greater element sotre the index of the greater element and the diff. b/w curr ele index and next greater ele index will be the answer.
    
    static class Pair{
        int price;
        int index;
    }
    
    Stack<Pair> st;
    int indOfPrice = 0;

    public StockSpanner() {
       st = new Stack<>();
        Pair base = new Pair();
        base.price = 1000000;
        base.index = -1;
        
        st.push(base);
        
    }
    
    public int next(int price) {
        Pair p = new Pair();
        p.price = price;
        p.index = indOfPrice;
        indOfPrice++;
        
        while(st.peek().price <= p.price){
            st.pop();
        }
        
        int ans = p.index - st.peek().index;
        
        st.push(p);
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */