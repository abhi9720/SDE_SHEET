class MyQueue {
    Stack<Integer> s1,s2;
    public MyQueue() {
        s1 =  new Stack<>();
        s2  =  new Stack<>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty() ){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty() ){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if(s1.size()==0) return -1;
        else return s1.pop();
    }
    
    public int peek() {
        if(s1.size()==0) return -1;
        else return s1.peek();
    }
    
    public boolean empty() {
        return s1.size()==0;
    }
}