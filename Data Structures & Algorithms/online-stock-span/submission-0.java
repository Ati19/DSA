class StockSpanner {

    Deque<int[]> stack;
    public StockSpanner() {
        stack=new ArrayDeque<>();
    }
    
    //returns the span of the stock - 4 lines of code
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            span+=stack.pop()[1];
        }
        stack.push(new int[]{price,span});
        return span;
        // int k=input.size();
        // input.add(price);
        // for(int i=0;i<input.size();i++){
        //     if(stack.isEmpty()){
        //         answer.add(-1);
        //     }
        //     else if(answer.get(stack.peek())<=input.get(i)){
        //         while(!stack.isEmpty() && answer.get(stack.peek())<=input.get(i)){
        //             stack.pop();
        //         }
        //         if(stack.isEmpty()){
        //             answer.add(-1);
        //         }
        //         else {
        //             answer.add(stack.peek());
        //         }
        //     }
        //     else{
        //         answer.add(stack.peek());
        //     }
        //     stack.add(i);
        // }
        // for(int i=0;i<answer.size();i++){
        //     answer.set(i,i-answer.get(i));
        // }
        // return answer.get(k);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */