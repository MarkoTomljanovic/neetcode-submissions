class MinStack {
    private final List<Integer> st = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        st.add(val);
    }
    
    public void pop() {
        st.remove(st.size()-1);
    }
    
    public int top() {
        return st.get(st.size()-1);
    }
    
    public int getMin() {
      int min = Integer.MAX_VALUE;

      for(int val:st){
        if(val<min){
            min=val;
        }
      } 
      return min; 
    }
}
