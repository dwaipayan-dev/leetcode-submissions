// Last updated: 6/25/2026, 8:38:43 AM
class Node{
    int min;
    int val;

    public Node(int min, int val){
        this.min = min;
        this.val = val;
    }

    public String toString(){
        return("["+val+","+min+"]");
    }
}
class MinStack {
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        } else {
            Node top = stack.peek();
            if(val < top.min){
                stack.push(new Node(val, val));
            }else{
                stack.push(new Node(top.min, val));
            }
        }
        //System.out.println(stack);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val; 
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */